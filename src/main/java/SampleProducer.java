import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class SampleProducer {
    public SampleProducer() {
        Properties properties = new Properties();
        // TODO: Replace `localhost` with the IP Address of your Local Machine
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        ProducerRecord producerRecord;
        for(String hero: new String[]{"ironman", "thor", "hulk", "spiderman", "blackwidow", "gamura"}) {
            producerRecord = new ProducerRecord("mychannel1", "name", hero);
            kafkaProducer.send(producerRecord);
        }

        kafkaProducer.close();
    }
}