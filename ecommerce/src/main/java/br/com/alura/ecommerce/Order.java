package br.com.alura.ecommerce;

import java.math.BigDecimal;


public class Order {
    public Order(String userId, String orderId, BigDecimal amount) {
        this.userId = userId;
        this.orderId = orderId;
        this.amount = amount;
    }

    private final String userId, orderId;
    private final BigDecimal amount;
}
