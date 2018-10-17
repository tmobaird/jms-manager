package io.tmobaird.springprojects.jms_manager.controllers.api;

import io.tmobaird.springprojects.jms_manager.QueueUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
