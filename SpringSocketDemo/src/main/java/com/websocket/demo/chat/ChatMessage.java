package com.websocket.demo.chat;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatMessage {
    private String content;
    private String timestamp;
    private String sender;
    private MessageType type;
    private static int user = 0;
    private int userreal;
    public void setCount(){
        user = user + 1;
    }
    public int getUserreal(){
        userreal = user;
        return userreal;
    }
    public static int removecount(){
        user = user -1;
        return user;
    }
}
