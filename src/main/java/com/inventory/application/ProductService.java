package com.inventory.application;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, String description, BigDecimal price, 
                                  Integer stockQuantity, String category) {
        logger.info("Creando nuevo producto con nombre: {}", name);
        
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setCategory(category);
        product.setCreatedAt(java.time.LocalDateTime.now());
        product.setUpdatedAt(java.time.LocalDateTime.now());
        
        product.validate();
        Product savedProduct = productRepository.save(product);
        
        logger.info("Producto creado exitosamente con ID: {}", savedProduct.getId());
        return savedProduct;
    }

    @Transactional(readOnly = true)
    public Optional<Product> getProductById(UUID id) {
        logger.debug("Buscando producto por ID: {}", id);
        return productRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        logger.debug("Obteniendo todos los productos");
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getProductsByCategory(String category) {
        logger.debug("Buscando productos por categoría: {}", category);
        return productRepository.findByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Product> getLowStockProducts(int threshold) {
        logger.debug("Buscando productos con stock bajo, umbral: {}", threshold);
        return productRepository.findLowStockProducts(threshold);
    }

    public Product updateProduct(UUID id, String name, String description, 
                                  BigDecimal price, Integer stockQuantity, String category) {
        logger.info("Actualizando producto con ID: {}", id);
        
        Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> {
                logger.error("Producto no encontrado para actualización: {}", id);
                return new ProductNotFoundException("Producto no encontrado con ID: " + id);
            });
        
        if (name != null && !name.isBlank()) {
            existingProduct.setName(name);
        }
        if (description != null) {
            existingProduct.setDescription(description);
        }
        if (price != null) {
            existingProduct.setPrice(price);
        }
        if (stockQuantity != null) {
            existingProduct.updateStockQuantity(stockQuantity);
        }
        if (category != null && !category.isBlank()) {
            existingProduct.setCategory(category);
        }
        
        existingProduct.setUpdatedAt(java.time.LocalDateTime.now());
        existingProduct.validate();
        
        Product updatedProduct = productRepository.save(existingProduct);
        logger.info("Producto actualizado exitosamente: {}", id);
        
        return updatedProduct;
    }

    public void deleteProduct(UUID id) {
        logger.info("Eliminando producto con ID: {}", id);
        
        if (!productRepository.findById(id).isPresent()) {
            logger.error("Producto no encontrado para eliminación: {}", id);
            throw new ProductNotFoundException("Producto no encontrado con ID: " + id);
        }
        
        productRepository.deleteById(id);
        logger.info("Producto eliminado exitosamente: {}", id);
    }

    public Product updateStock(UUID id, int quantityChange) {
        logger.info("Actualizando stock del producto ID: {}, cambio: {}", id, quantityChange);
        
        Product product = productRepository.findById(id)
            .orElseThrow(() -> {
                logger.error("Producto no encontrado para actualización de stock: {}", id);
                return new ProductNotFoundException("Producto no encontrado con ID: " + id);
            });
        
        int newQuantity = product.getStockQuantity() + quantityChange;
        if (newQuantity < 0) {
            logger.error("Stock no puede ser negativo para producto ID: {}", id);
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        
        product.updateStockQuantity(newQuantity);
        product.setUpdatedAt(java.time.LocalDateTime.now());
        
        Product updatedProduct = productRepository.save(product);
        logger.info("Stock actualizado para producto ID: {}, nuevo stock: {}", id, newQuantity);
        
        return updatedProduct;
    }

    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }
}