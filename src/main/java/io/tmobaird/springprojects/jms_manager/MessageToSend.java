package io.tmobaird.springprojects.jms_manager;

import java.io.Serializable;

public class MessageToSend implements Serializable {
    private String destination;
    private String text;

    public MessageToSend() {
    }

    public MessageToSend(String destination, String text) {
        this.destination = destination;
        this.text = text;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
