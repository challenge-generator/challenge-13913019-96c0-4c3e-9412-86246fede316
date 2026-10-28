package com.inventory.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 * Entidad de dominio que representa un producto en el inventario.
 * Contiene los atributos esenciales de un producto y valida su estado.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private UUID id;

    @NotNull(message = "El nombre del producto no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String name;

    @NotNull(message = "La descripción del producto no puede ser nula")
    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    private String description;

    @NotNull(message = "El precio del producto no puede ser nulo")
    @Positive(message = "El precio debe ser un valor positivo")
    private BigDecimal price;

    @NotNull(message = "La cantidad en stock no puede ser nula")
    @Positive(message = "La cantidad en stock debe ser un valor positivo o cero")
    private Integer stockQuantity;

    @NotNull(message = "La categoría del producto no puede ser nula")
    @Size(min = 3, max = 50, message = "La categoría debe tener entre 3 y 50 caracteres")
    private String category;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * Actualiza la cantidad en stock del producto.
     * @param quantity Cantidad a agregar o restar del stock actual.
     * @throws IllegalArgumentException si la cantidad resultante es negativa.
     */
    public void updateStockQuantity(int quantity) {
        int newQuantity = this.stockQuantity + quantity;
        if (newQuantity < 0) {
            throw new IllegalArgumentException("No hay suficiente stock para realizar la operación");
        }
        this.stockQuantity = newQuantity;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Valida que el producto cumpla con todas las restricciones de negocio.
     * @throws IllegalStateException si alguna validación falla.
     */
    public void validate() {
        if (this.name == null || this.name.trim().isEmpty()) {
            throw new IllegalStateException("El nombre del producto es obligatorio");
        }
        if (this.price == null || this.price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("El precio debe ser un valor positivo");
        }
        if (this.stockQuantity == null || this.stockQuantity < 0) {
            throw new IllegalStateException("La cantidad en stock no puede ser negativa");
        }
        if (this.category == null || this.category.trim().isEmpty()) {
            throw new IllegalStateException("La categoría del producto es obligatoria");
        }
    }
}