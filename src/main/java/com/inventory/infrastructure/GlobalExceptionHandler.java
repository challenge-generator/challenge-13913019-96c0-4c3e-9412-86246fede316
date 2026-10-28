package com.inventory.infrastructure;

import com.inventory.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        logger.warn("Validation error: {}", ex.getMessage());
        
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            fieldErrors.put(error.getField(), error.getDefaultMessage())
        );
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.BAD_REQUEST,
            "Validation failed",
            "Los datos proporcionados no son válidos",
            request
        );
        response.put("fieldErrors", fieldErrors);
        
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        logger.error("Invalid argument: {}", ex.getMessage());
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.BAD_REQUEST,
            "Invalid argument",
            ex.getMessage(),
            request
        );
        
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFoundException(
            ProductNotFoundException ex, WebRequest request) {
        logger.warn("Product not found: {}", ex.getMessage());
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.NOT_FOUND,
            "Product not found",
            ex.getMessage(),
            request
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<Map<String, Object>> handleInsufficientStockException(
            InsufficientStockException ex, WebRequest request) {
        logger.warn("Insufficient stock: {}", ex.getMessage());
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.CONFLICT,
            "Insufficient stock",
            ex.getMessage(),
            request
        );
        response.put("availableStock", ex.getAvailableStock());
        response.put("requestedStock", ex.getRequestedStock());
        
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(
            Exception ex, WebRequest request) {
        logger.error("Unexpected error: {}", ex.getMessage(), ex);
        
        Map<String, Object> response = buildErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Internal server error",
            "Ha ocurrido un error inesperado. Por favor, contacte al administrador.",
            request
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    private Map<String, Object> buildErrorResponse(
            HttpStatus status, String error, String message, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", status.value());
        response.put("error", error);
        response.put("message", message);
        response.put("path", request.getDescription(false).replace("uri=", ""));
        response.put("traceId", UUID.randomUUID().toString());
        return response;
    }
}

class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class InsufficientStockException extends RuntimeException {
    private final int availableStock;
    private final int requestedStock;

    public InsufficientStockException(String message, int availableStock, int requestedStock) {
        super(message);
        this.availableStock = availableStock;
        this.requestedStock = requestedStock;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public int getRequestedStock() {
        return requestedStock;
    }
}