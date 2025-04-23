package br.com.alura.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var orderDispatcher = new KafkaDispatcher<Order>()) {
            try (var dispatcher = new KafkaDispatcher<Order>()) {
                for (var i = 0; i < 15; i++) {

                    var userId = UUID.randomUUID().toString();
                    var orderId = UUID.randomUUID().toString();
                    var amount = new BigDecimal(Math.random() * 5000 + 1);

                    var order = new Order(userId, orderId, amount);
                    dispatcher.send("ECOMMERCE_NEW_ORDER", userId, order);

                    var email = "Welcome! We're processing your order.";
                    dispatcher.send("ECOMMERCE_SEND_EMAIL", userId, email);
                }
            }
        }
    }
}
