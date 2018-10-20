# JMS Manager

A spring boot application that allows you to manage different aspects of your JMS queues.

The application allows for similar abilities that the ActiveMQ web app provides.

### Tech Stack

- Java
- Gradle
- Spring
- Spring Boot Web
- Thymeleaf
- JUnit
- Mockito

### Todo (API)

- [x] Get queue info
- [x] Get number of messages in queue
- [x] Get queue size in KB
- [x] Get all messages in queue
- [x] Get a single message in queue (by JMS message id)
- [x] Create message in queue
- [x] Delete message in queue
- [ ] Move message in queue to another queue
- [ ] Move all messages in queue to another queue
- [x] Purge queue

- [ ] Test config for in memory ActiveMQ
- [ ] Better handle non 200s
- [ ] Testing controllers?