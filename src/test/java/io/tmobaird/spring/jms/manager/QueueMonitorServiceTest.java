package io.tmobaird.spring.jms.manager;

import io.tmobaird.spring.jms.manager.browser.callbacks.MessageCountCallback;
import io.tmobaird.spring.jms.manager.browser.callbacks.QueueSizeCallback;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jms.core.JmsTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.when;

public class QueueMonitorServiceTest {

    @Test
    public void getQueueInfo_ReturnsQueueInfo() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        when(
                jmsTemplate.browse(any(String.class), any(MessageCountCallback.class))
        ).thenReturn(1);
        when(
                jmsTemplate.browse(any(String.class), any(QueueSizeCallback.class))
        ).thenReturn(1000);

        QueueMonitorService service = new QueueMonitorService(jmsTemplate);
        QueueInfo result = service.getQueueInfo("Queue Name");

        assertEquals("Queue Name", result.getName());
    }

    @Test
    public void getQueueInfo_ReturnsQueueInfo_WithMessagesCount() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        when(
                jmsTemplate.browse(same("Queue Name"), any(MessageCountCallback.class))
        ).thenReturn(1);
        when(
                jmsTemplate.browse(same("Queue Name"), any(QueueSizeCallback.class))
        ).thenReturn(1000);

        QueueMonitorService service = new QueueMonitorService(jmsTemplate);
        QueueInfo result = service.getQueueInfo("Queue Name");

        assertEquals(1, result.getMessagesCount());
    }

    @Test
    public void getQueueInfo_ReturnsQueueInfo_WithQueueSize() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        when(
                jmsTemplate.browse(same("Queue Name"), any(MessageCountCallback.class))
        ).thenReturn(1);
        when(
                jmsTemplate.browse(same("Queue Name"), any(QueueSizeCallback.class))
        ).thenReturn(1000);

        QueueMonitorService service = new QueueMonitorService(jmsTemplate);
        QueueInfo result = service.getQueueInfo("Queue Name");

        assertEquals(1000, result.getQueueSize());
    }
}
