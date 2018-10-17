package io.tmobaird.springprojects.jms_manager;

import io.tmobaird.springprojects.jms_manager.browser.callbacks.MessageCountCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueUtilityService {
    private JmsTemplate template;

    @Autowired
    public QueueUtilityService(JmsTemplate template) {
        this.template = template;
    }

    public void purge(String name) {
        template.setReceiveTimeout(1000);

        int messageCount = template.browse(name, new MessageCountCallback());

        for(int i = 0; i < messageCount; i++) {
            template.receive(name);
        }
    }
}
