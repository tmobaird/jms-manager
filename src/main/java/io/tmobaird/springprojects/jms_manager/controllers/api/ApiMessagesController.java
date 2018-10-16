package io.tmobaird.springprojects.jms_manager.controllers.api;

import io.tmobaird.springprojects.jms_manager.QueueMessageService;
import io.tmobaird.springprojects.jms_manager.SimpleTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queue/{queueName}/messages")
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

    @GetMapping("/{id}")
    public SimpleTextMessage show(@PathVariable String queueName, @PathVariable String id) {
        return messageService.getMessage(queueName, id);
    }

    @PostMapping("/move")
    public String moveAll(@PathVariable String queueName, @RequestBody String destination) {
        return "Moved Messages from " + queueName + " to " + destination;
    }

    @PostMapping("/{id}/move")
    public String move(@PathVariable String queueName, @PathVariable String id, @RequestBody String destination) {
        return "Moved Message " + id + " from " + queueName + " to " + destination;
    }
}
