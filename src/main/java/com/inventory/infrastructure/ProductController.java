package com.inventory.infrastructure;

import com.inventory.application.ProductService;
import com.inventory.domain.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        logger.info("Recibida petición para crear producto: {}", request.name());
        
        Product product = productService.createProduct(
            request.name(),
            request.description(),
            request.price(),
            request.stockQuantity(),
            request.category()
        );
        
        ProductResponse response = ProductResponse.fromDomain(product);
        logger.info("Producto creado exitosamente con ID: {}", product.getId());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID id) {
        logger.debug("Recibida petición para obtener producto por ID: {}", id);
        
        return productService.getProductById(id)
            .map(product -> {
                ProductResponse response = ProductResponse.fromDomain(product);
                return ResponseEntity.ok(response);
            })
            .orElseGet(() -> {
                logger.warn("Producto no encontrado con ID: {}", id);
                return ResponseEntity.notFound().build();
            });
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        logger.debug("Recibida petición para obtener todos los productos");
        
        List<ProductResponse> products = productService.getAllProducts()
            .stream()
            .map(ProductResponse::fromDomain)
            .toList();
        
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable String category) {
        logger.debug("Recibida petición para obtener productos por categoría: {}", category);
        
        List<ProductResponse> products = productService.getProductsByCategory(category)
            .stream()
            .map(ProductResponse::fromDomain)
            .toList();
        
        return ResponseEntity.ok(products);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductResponse>> getLowStockProducts(
            @RequestParam(defaultValue = "10") int threshold) {
        logger.debug("Recibida petición para obtener productos con stock bajo, umbral: {}", threshold);
        
        List<ProductResponse> products = productService.getLowStockProducts(threshold)
            .stream()
            .map(ProductResponse::fromDomain)
            .toList();
        
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable UUID id,
            @Valid @RequestBody ProductUpdateRequest request) {
        logger.info("Recibida petición para actualizar producto ID: {}", id);
        
        Product product = productService.updateProduct(
            id,
            request.name(),
            request.description(),
            request.price(),
            request.stockQuantity(),
            request.category()
        );
        
        ProductResponse response = ProductResponse.fromDomain(product);
        logger.info("Producto actualizado exitosamente ID: {}", id);
        
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        logger.info("Recibida petición para eliminar producto ID: {}", id);
        
        productService.deleteProduct(id);
        logger.info("Producto eliminado exitosamente ID: {}", id);
        
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductResponse> updateStock(
            @PathVariable UUID id,
            @Valid @RequestBody StockUpdateRequest request) {
        logger.info("Recibida petición para actualizar stock del producto ID: {}, cambio: {}", 
                    id, request.quantityChange());
        
        Product product = productService.updateStock(id, request.quantityChange());
        ProductResponse response = ProductResponse.fromDomain(product);
        
        logger.info("Stock actualizado para producto ID: {}", id);
        return ResponseEntity.ok(response);
    }

    record ProductRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        String description,
        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser positivo")
        BigDecimal price,
        @NotNull(message = "La cantidad en stock es obligatoria")
        @Positive(message = "La cantidad en stock debe ser positiva")
        Integer stockQuantity,
        @NotBlank(message = "La categoría es obligatoria")
        String category
    ) {}

    record ProductUpdateRequest(
        String name,
        String description,
        @Positive(message = "El precio debe ser positivo")
        BigDecimal price,
        @Positive(message = "La cantidad en stock debe ser positiva")
        Integer stockQuantity,
        String category
    ) {}

    record StockUpdateRequest(
        @NotNull(message = "El cambio de cantidad es obligatorio")
        Integer quantityChange
    ) {}

    record ProductResponse(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        Integer stockQuantity,
        String category,
        String createdAt,
        String updatedAt
    ) {
        static ProductResponse fromDomain(Product product) {
            return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getCategory(),
                product.getCreatedAt() != null ? product.getCreatedAt().toString() : null,
                product.getUpdatedAt() != null ? product.getUpdatedAt().toString() : null
            );
        }
    }
}