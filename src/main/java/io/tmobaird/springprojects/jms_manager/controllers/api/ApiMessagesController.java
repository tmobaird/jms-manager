package io.tmobaird.springprojects.jms_manager.controllers.api;

import io.tmobaird.springprojects.jms_manager.QueueMessageService;
import io.tmobaird.springprojects.jms_manager.SimpleTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queues/{queueName}/messages")
public class ApiMessagesController {

    private QueueMessageService messageService;

    @Autowired
    public ApiMessagesController(QueueMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<SimpleTextMessage> index(@PathVariable String queueName) {
        return messageService.getMessages(queueName);
    }

    @PostMapping
    public String create(@PathVariable String queueName, @RequestBody SimpleTextMessage message) {
        return "Creating and adding message: " + message + " to " + queueName;
    }

    @GetMapping("/{id}")
    public SimpleTextMessage show(@PathVariable String queueName, @PathVariable String id) {
        return messageService.getMessage(queueName, id);
    }

    @DeleteMapping("/{id}")
    public String destroy(@PathVariable String queueName, @PathVariable String id) {
        messageService.deleteMessage(queueName, id);
        return "Deleted Message " + id + " from " + queueName;
    }
}
