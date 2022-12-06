import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class ScaledProducer {
    public ScaledProducer() {
        Properties properties = new Properties();
        // TODO: Replace `localhost` with the IP Address of your Local Machine
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        String topic_name = "topic1";

        List<String> keys = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++) {
            keys.add("keys" + Integer.toString(i));
        }

        Random randomGenerator = new Random();

        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        // TODO: We can change the number of records to be produced here
        long total_number_of_records = 1000;
        for(long j = 0 ; j < total_number_of_records ; j++) {
            String curr_key = keys.get(randomGenerator.nextInt(keys.size()));
            // System.out.println(curr_key);
            ProducerRecord producerRecord = new ProducerRecord(topic_name, curr_key, "value_" + Long.toString(j));
            kafkaProducer.send(producerRecord);
        }

        kafkaProducer.close();
    }
}