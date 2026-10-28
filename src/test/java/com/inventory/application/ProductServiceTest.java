package com.inventory.application;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product testProduct;
    private UUID testProductId;

    @BeforeEach
    void setUp() {
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
    }

    @Test
    @DisplayName("Should create a new product successfully")
    void testCreateProduct_Success() {
        when(productRepository.save(any(Product.class))).thenReturn(testProduct);

        Product created = productService.createProduct(testProduct);

        assertNotNull(created);
        assertEquals("Test Product", created.getName());
        assertEquals("Electronics", created.getCategory());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("Should retrieve product by ID")
    void testGetProductById_Found() {
        when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));

        Optional<Product> result = productService.getProductById(testProductId);

        assertTrue(result.isPresent());
        assertEquals(testProductId, result.get().getId());
        verify(productRepository, times(1)).findById(testProductId);
    }

    @Test
    @DisplayName("Should return empty when product not found")
    void testGetProductById_NotFound() {
        UUID nonExistentId = UUID.randomUUID();
        when(productRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        Optional<Product> result = productService.getProductById(nonExistentId);

        assertTrue(result.isEmpty());
        verify(productRepository, times(1)).findById(nonExistentId);
    }

    @Test
    @DisplayName("Should retrieve all products")
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(testProduct, createAnotherProduct());
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should update product successfully")
    void testUpdateProduct_Success() {
        Product updatedDetails = new Product();
        updatedDetails.setName("Updated Name");
        updatedDetails.setDescription("Updated Description");
        updatedDetails.setPrice(new BigDecimal("149.99"));
        updatedDetails.setStockQuantity(100);
        updatedDetails.setCategory("Updated Category");

        when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Product result = productService.updateProduct(testProductId, updatedDetails);

        assertNotNull(result);
        assertEquals("Updated Name", result.getName());
        assertEquals(new BigDecimal("149.99"), result.getPrice());
        verify(productRepository, times(1)).findById(testProductId);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("Should delete product by ID")
    void testDeleteProduct_Success() {
        doNothing().when(productRepository).deleteById(testProductId);

        productService.deleteProduct(testProductId);

        verify(productRepository, times(1)).deleteById(testProductId);
    }

    @Test
    @DisplayName("Should find products by category")
    void testFindByCategory() {
        List<Product> electronicsProducts = Arrays.asList(
            testProduct,
            createAnotherProduct()
        );
        when(productRepository.findByCategory("Electronics")).thenReturn(electronicsProducts);

        List<Product> result = productService.findByCategory("Electronics");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(p -> "Electronics".equals(p.getCategory())));
        verify(productRepository, times(1)).findByCategory("Electronics");
    }

    @Test
    @DisplayName("Should find low stock products")
    void testFindLowStockProducts() {
        Product lowStockProduct = new Product();
        lowStockProduct.setId(UUID.randomUUID());
        lowStockProduct.setName("Low Stock Item");
        lowStockProduct.setStockQuantity(5);

        List<Product> lowStockProducts = Arrays.asList(lowStockProduct);
        when(productRepository.findLowStockProducts(10)).thenReturn(lowStockProducts);

        List<Product> result = productService.findLowStockProducts(10);

        assertEquals(1, result.size());
        assertTrue(result.stream().allMatch(p -> p.getStockQuantity() < 10));
        verify(productRepository, times(1)).findLowStockProducts(10);
    }

    @Test
    @DisplayName("Should update stock quantity")
    void testUpdateStockQuantity() {
        when(productRepository.findById(testProductId)).thenReturn(Optional.of(testProduct));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Product result = productService.updateStockQuantity(testProductId, 75);

        assertEquals(75, result.getStockQuantity());
        verify(productRepository, times(1)).findById(testProductId);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("Should throw exception when updating stock of non-existent product")
    void testUpdateStockQuantity_ProductNotFound() {
        UUID nonExistentId = UUID.randomUUID();
        when(productRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, 
            () -> productService.updateStockQuantity(nonExistentId, 100));
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