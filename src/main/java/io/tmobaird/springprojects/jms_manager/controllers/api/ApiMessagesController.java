package io.tmobaird.springprojects.jms_manager.controllers.api;

import io.tmobaird.springprojects.jms_manager.QueueMessageService;
import io.tmobaird.springprojects.jms_manager.SimpleTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.TextMessage;
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
}
