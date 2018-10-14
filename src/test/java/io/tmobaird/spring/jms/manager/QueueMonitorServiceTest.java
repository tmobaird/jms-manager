package io.tmobaird.spring.jms.manager;

import io.tmobaird.spring.jms.manager.browser.callbacks.MessageCountCallback;
import io.tmobaird.spring.jms.manager.browser.callbacks.QueueInfoCallback;
import io.tmobaird.spring.jms.manager.browser.callbacks.QueueSizeCallback;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jms.core.JmsTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class QueueMonitorServiceTest {

    @Test
    public void getQueueInfo_ReturnsQueueInfo() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        when(jmsTemplate.browse(any(String.class), any(QueueInfoCallback.class)))
                .thenReturn(new QueueInfo("Queue Name", 1, 100));

        QueueMonitorService service = new QueueMonitorService(jmsTemplate);
        QueueInfo result = service.getQueueInfo("Queue Name");

        assertEquals("Queue Name", result.getName());
        assertEquals(1, result.getMessagesCount());
        assertEquals(100, result.getQueueSize());
    }

    @Test
    public void getNumberOfMessagesInQueue_ReturnsNumberOfMessages() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        when(jmsTemplate.browse(any(String.class), any(MessageCountCallback.class)))
                .thenReturn(1);

        QueueMonitorService service = new QueueMonitorService(jmsTemplate);
        int result = service.getNumberOfMessagesInQueue("Queue Name");

        assertEquals(1, result);
    }

    @Test
    public void getSizeOfQueue_ReturnsSizeOfQueue() {
        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);
        when(jmsTemplate.browse(any(String.class), any(QueueSizeCallback.class)))
                .thenReturn(100);

        QueueMonitorService service = new QueueMonitorService(jmsTemplate);
        int result = service.getQueueSize("Queue Name");

        assertEquals(100, result);
    }
}
