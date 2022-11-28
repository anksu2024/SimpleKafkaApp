# SimpleKafkaApp

```docker-compose -f docker-compose.yml up```

```docker exec -it kafka /bin/sh```

```cd /opt/kafka/bin```

```./kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic mychannel1```
```./kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 10 --topic topic1```
```./kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 10 --topic topic2```

```./kafka-topics.sh --list --zookeeper zookeeper:2181```

```./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mychannel1 --from-beginning```
```./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic1 --from-beginning```

```./kafka-topics.sh --zookeeper zookeeper:2181 --delete --topic mychannel1```
```./kafka-topics.sh --zookeeper zookeeper:2181 --delete --topic topic1```

```./kafka-console-producer.sh --topic mtchannel1 --broker-list localhost:9092```

```./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic1 --from-beginning | ./kafka-console-producer.sh --topic topic2 --broker-list localhost:9092```
<br />
Note: The number of partitions in both the source and destination topics needs to be the same

```./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic2 --from-beginning```


