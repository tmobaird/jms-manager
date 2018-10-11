package io.tmobaird.spring.jms.manager;

public class QueueInfo {
    private String name;
    private int messagesCount;
    private int queueSize; // in Kilobytes

    public QueueInfo(String name) {
        this.name = name;
    }

    QueueInfo(String name, int messagesCount, int queueSize) {
        this.name = name;
        this.messagesCount = messagesCount;
        this.queueSize = queueSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }

    int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }
}
