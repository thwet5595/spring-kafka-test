# spring-kafka-test

Prerequisite for this project:

1.	Java JDK 8 
2.	Maven 
3.	Kafka
4.  ZooKeeper


# Run project locally
```bash
- Run Zookeeper
$ .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
- Run Kafka
$ .\bin\windows\kafka-server-start.bat .\config\server.properties
- Create Topic
$ .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic (topicname)
$ git clone https://github.com/thwet5595/spring-kafka-test.git
$ cd spring-kafka-test/
$ mvn clean package
Run Project with .jar
$ java -jar target/*.jar 
Run Project with maven
mvn spring-boot:run

```

# Technologies Used
```bash
Java 8
SpringBoot
```
