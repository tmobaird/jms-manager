package io.tmobaird.springprojects.jms_manager.controllers.api;

import io.tmobaird.springprojects.jms_manager.QueueInfo;
import io.tmobaird.springprojects.jms_manager.QueueMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/queues")
public class ApiQueueController {
    private QueueMonitorService monitorService;

    @Autowired
    public ApiQueueController(QueueMonitorService monitorService) {
        this.monitorService = monitorService;
    }

    // This handles the no path variable default route
    // from https://stackoverflow.com/a/41620493
    @GetMapping("")
    public String showNoParams() {
        return "Please enter a queue name";
    }

    @GetMapping(value = "{name}")
    public QueueInfo show(@PathVariable String name) {
        return monitorService.getQueueInfo(name);
    }

    @GetMapping(value = "{name}/message_count")
    public Integer messageCount(@PathVariable String name) {
        return monitorService.getNumberOfMessagesInQueue(name);
    }

    @GetMapping(value = "{name}/size")
    public Integer queueSize(@PathVariable String name) {
        return monitorService.getQueueSize(name);
    }
}
