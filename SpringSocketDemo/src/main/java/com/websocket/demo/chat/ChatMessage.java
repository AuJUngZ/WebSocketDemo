package com.websocket.demo.chat;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class ChatMessage {
    private String content;
    private String timestamp;
    private String sender;
    private MessageType type;
    private int chatCC;
    public static int CC;
    public static int increaseCC(){
        CC += 1;
        return CC;
    }
    public static int decreaseCC(){
        CC -= 1;
        return CC;
    }
}