package com.inventory.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.application.ProductService;
import com.inventory.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    private Product testProduct;
    private UUID testProductId;
    private String productJson;

    @BeforeEach
    void setUp() throws Exception {
        testProductId = UUID.randomUUID();
        testProduct = new Product();
        testProduct.setId(testProductId);
        testProduct.setName("Test Product");
        testProduct.setDescription("Test Description");
        testProduct.setPrice(new BigDecimal("99.99"));
        testProduct.setStockQuantity(50);
        testProduct.setCategory("Electronics");
        testProduct.setCreatedAt(LocalDateTime.now());
        testProduct.setUpdatedAt(LocalDateTime.now());
        
        productJson = objectMapper.writeValueAsString(testProduct);
    }

    @Test
    @DisplayName("Should create product and return 201 Created")
    void testCreateProduct_Returns201() throws Exception {
        when(productService.createProduct(any(Product.class))).thenReturn(testProduct);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(testProductId.toString()))
                .andExpect(jsonPath("$.name").value("Test Product"))
                .andExpect(jsonPath("$.category").value("Electronics"));

        verify(productService, times(1)).createProduct(any(Product.class));
    }

    @Test
    @DisplayName("Should return 400 when creating product with invalid data")
    void testCreateProduct_Returns400_ValidationError() throws Exception {
        Product invalidProduct = new Product();
        invalidProduct.setName(null);
        invalidProduct.setPrice(BigDecimal.valueOf(-10));
        
        String invalidJson = objectMapper.writeValueAsString(invalidProduct);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should retrieve product by ID")
    void testGetProductById_Returns200() throws Exception {
        when(productService.getProductById(testProductId)).thenReturn(Optional.of(testProduct));

        mockMvc.perform(get("/api/products/{id}", testProductId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testProductId.toString()))
                .andExpect(jsonPath("$.name").value("Test Product"));

        verify(productService, times(1)).getProductById(testProductId);
    }

    @Test
    @DisplayName("Should return 404 when product not found")
    void testGetProductById_Returns404() throws Exception {
        UUID nonExistentId = UUID.randomUUID();
        when(productService.getProductById(nonExistentId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/products/{id}", nonExistentId))
                .andExpect(status().isNotFound());

        verify(productService, times(1)).getProductById(nonExistentId);
    }

    @Test
    @DisplayName("Should retrieve all products")
    void testGetAllProducts_Returns200() throws Exception {
        List<Product> products = Arrays.asList(testProduct, createAnotherProduct());
        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Test Product"))
                .andExpect(jsonPath("$[1].name").value("Another Product"));

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    @DisplayName("Should return empty list when no products exist")
    void testGetAllProducts_ReturnsEmptyList() throws Exception {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    @DisplayName("Should update product and return 200")
    void testUpdateProduct_Returns200() throws Exception {
        Product updatedProduct = new Product();
        updatedProduct.setId(testProductId);
        updatedProduct.setName("Updated Product");
        updatedProduct.setDescription("Updated Description");
        updatedProduct.setPrice(new BigDecimal("149.99"));
        updatedProduct.setStockQuantity(75);
        updatedProduct.setCategory("Updated Electronics");
        updatedProduct.setCreatedAt(testProduct.getCreatedAt());
        updatedProduct.setUpdatedAt(LocalDateTime.now());

        when(productService.updateProduct(eq(testProductId), any(Product.class)))
                .thenReturn(updatedProduct);

        String updatedJson = objectMapper.writeValueAsString(updatedProduct);

        mockMvc.perform(put("/api/products/{id}", testProductId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Product"))
                .andExpect(jsonPath("$.price").value(149.99));

        verify(productService, times(1)).updateProduct(eq(testProductId), any(Product.class));
    }

    @Test
    @DisplayName("Should return 404 when updating non-existent product")
    void testUpdateProduct_Returns404() throws Exception {
        UUID nonExistentId = UUID.randomUUID();
        when(productService.updateProduct(eq(nonExistentId), any(Product.class)))
                .thenThrow(new NoSuchElementException("Product not found"));

        mockMvc.perform(put("/api/products/{id}", nonExistentId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Should delete product and return 204")
    void testDeleteProduct_Returns204() throws Exception {
        doNothing().when(productService).deleteProduct(testProductId);

        mockMvc.perform(delete("/api/products/{id}", testProductId))
                .andExpect(status().isNoContent());

        verify(productService, times(1)).deleteProduct(testProductId);
    }

    @Test
    @DisplayName("Should search products by category")
    void testSearchByCategory_Returns200() throws Exception {
        List<Product> electronicsProducts = Arrays.asList(testProduct);
        when(productService.findByCategory("Electronics")).thenReturn(electronicsProducts);

        mockMvc.perform(get("/api/products/search")
                .param("category", "Electronics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].category").value("Electronics"));

        verify(productService, times(1)).findByCategory("Electronics");
    }

    @Test
    @DisplayName("Should get low stock products")
    void testGetLowStockProducts_Returns200() throws Exception {
        Product lowStockProduct = new Product();
        lowStockProduct.setId(UUID.randomUUID());
        lowStockProduct.setName("Low Stock Item");
        lowStockProduct.setStockQuantity(5);
        lowStockProduct.setCategory("Low Stock Category");

        List<Product> lowStockList = Arrays.asList(lowStockProduct);
        when(productService.findLowStockProducts(10)).thenReturn(lowStockList);

        mockMvc.perform(get("/api/products/low-stock")
                .param("threshold", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].stockQuantity").value(5));

        verify(productService, times(1)).findLowStockProducts(10);
    }

    private Product createAnotherProduct() {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName("Another Product");
        product.setDescription("Another Description");
        product.setPrice(new BigDecimal("199.99"));
        product.setStockQuantity(25);
        product.setCategory("Electronics");
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }
}