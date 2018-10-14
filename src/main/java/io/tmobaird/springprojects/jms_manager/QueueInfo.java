package io.tmobaird.springprojects.jms_manager;

public class QueueInfo {
    private String name;
    private int messagesCount;
    private int queueSize; // in Kilobytes

    public QueueInfo(String name) {
        this.name = name;
    }

    public QueueInfo(String name, int messagesCount, int queueSize) {
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

    public int getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }
}
