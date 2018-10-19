package io.tmobaird.springprojects.jms_manager.controllers.api;

import io.tmobaird.springprojects.jms_manager.QueueMessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/queues/{queueName}/messages")
public class ApiMessagesUtilityController {
    private QueueMessageService messageService;

    @PutMapping("/{id}/move")
    public String move(@PathVariable String queueName, @PathVariable String id, @RequestBody String destination) {
        return "Moved Message " + id + " from " + queueName + " to " + destination;
    }
}
