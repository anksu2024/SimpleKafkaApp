# SimpleKafkaApp

```docker-compose -f docker-compose.yml up ```

```docker exec -it Kafka /bin/sh```

```cd /opt/kafka/bin```

```./kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic dest_channel2```

```./kafka-topics.sh --list --zookeeper zookeeper:2181```

```./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mychannel1 --from-beginning```

```./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic dest_channel2 --from-beginning```

```./kafka-topics.sh --zookeeper zookeeper:2181 --delete --topic src_channel```

```./kafka-console-producer.sh --topic channel --broker-list localhost:9092```

```./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mychannel1 --from-beginning | ./kafka-console-producer.sh --topic mychannel2 --broker-list localhost:9092```
<br />
Note: The number of partitions in both the source and destination topics needs to be the same



