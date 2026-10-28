package com.inventory.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interfaz del puerto para operaciones de persistencia del producto.
 * Define los contratos que la capa de infraestructura debe implementar
 * para interactuar con el almacenamiento de productos.
 */
public interface ProductRepository {
    /**
     * Guarda un producto en el repositorio.
     * @param product Producto a guardar.
     * @return Producto guardado con su ID generado.
     */
    Product save(Product product);

    /**
     * Busca un producto por su ID.
     * @param id ID del producto a buscar.
     * @return Optional con el producto si existe, vacío en caso contrario.
     */
    Optional<Product> findById(UUID id);

    /**
     * Busca todos los productos en el repositorio.
     * @return Lista de todos los productos.
     */
    List<Product> findAll();

    /**
     * Elimina un producto por su ID.
     * @param id ID del producto a eliminar.
     */
    void deleteById(UUID id);

    /**
     * Busca productos por categoría.
     * @param category Categoría a buscar.
     * @return Lista de productos que pertenecen a la categoría.
     */
    List<Product> findByCategory(String category);

    /**
     * Busca productos con stock bajo.
     * @param threshold Umbral para considerar stock bajo.
     * @return Lista de productos con stock menor o igual al umbral.
     */
    List<Product> findLowStockProducts(int threshold);
}