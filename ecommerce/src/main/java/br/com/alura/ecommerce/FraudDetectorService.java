package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorService {

    public static void main (String[] args) {
        var fraudeService = new FraudDetectorService();
        var service = new KafkaService(
                  FraudDetectorService.class.getSimpleName()
                , "ECOMMERCE_NEW_ORDER"
                , fraudeService::parse);
        service.run();
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("-------------");
        System.out.println("Processing");
        System.out.println(record.key() + " - " + record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing");
    }
}
