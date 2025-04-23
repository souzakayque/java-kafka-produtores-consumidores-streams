package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class SendEmailService {
    public static void main(String[] args) {
        var emailService = new SendEmailService();
        try (var service = new KafkaService(
              FraudDetectorService.class.getSimpleName()
            , "ECOMMERCE_SEND_EMAIL"
            , emailService::parse
            , String.class
            , Map.of())) {
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("-------------");
        System.out.println("Processing");
        System.out.println("Key: " + record.key());
        System.out.println("Value: " + record.value());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing");
    }


}
