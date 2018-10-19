package io.tmobaird.springprojects.jms_manager.controllers.api;

import io.tmobaird.springprojects.jms_manager.QueueUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/queues")
public class ApiQueueUtilityController {
    private QueueUtilityService utilityService;

    @Autowired
    public ApiQueueUtilityController(QueueUtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @PutMapping("/{name}/purge")
    public void purge(@PathVariable String name) {
        utilityService.purge(name);
    }

    @PutMapping("/{name}/move")
    public String moveAll(@PathVariable String name, @RequestBody String destination) {
        return "Moved Messages from " + name + " to " + destination;
    }
}
