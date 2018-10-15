package io.tmobaird.springprojects.jms_manager;

import io.tmobaird.springprojects.jms_manager.browser.callbacks.GetMessagesCallback;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.TextMessage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class QueueMessageServiceTest {

    @Test
    public void getMessage_ReturnsListOfMessagesFromQueue() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        QueueMessageService service = new QueueMessageService(jmsTemplate);

        when(jmsTemplate.browse(eq("Queue Name"), any(GetMessagesCallback.class)))
                .thenReturn(new ArrayList<>());

        List<SimpleTextMessage> messages = service.getMessages("Queue Name");

        assertEquals(0, messages.size());
    }
}