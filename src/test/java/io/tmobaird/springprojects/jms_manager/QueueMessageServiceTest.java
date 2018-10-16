package io.tmobaird.springprojects.jms_manager;

import io.tmobaird.springprojects.jms_manager.browser.callbacks.GetMessageCallback;
import io.tmobaird.springprojects.jms_manager.browser.callbacks.GetMessagesCallback;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jms.core.JmsTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class QueueMessageServiceTest {

    @Test
    public void getMessages_ReturnsListOfMessagesFromQueue() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        QueueMessageService service = new QueueMessageService(jmsTemplate);

        when(jmsTemplate.browse(eq("Queue Name"), any(GetMessagesCallback.class)))
                .thenReturn(new ArrayList<>());

        List<SimpleTextMessage> messages = service.getMessages("Queue Name");

        assertEquals(0, messages.size());
    }

    @Test
    public void getMessage_ReturnsListOfMessagesFromQueue() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        QueueMessageService service = new QueueMessageService(jmsTemplate);

        SimpleTextMessage result = new SimpleTextMessage();
        result.setId("MessageID:123");
        result.setText("This is some text");
        when(jmsTemplate.browseSelected(eq("QueueName"), eq("JMSMessageID='MessageID:123'"), any(GetMessageCallback.class)))
                .thenReturn(result);

        SimpleTextMessage message = service.getMessage("QueueName", "MessageID:123");

        assertEquals("MessageID:123", message.getId());
        assertEquals("This is some text", message.getText());
    }
}