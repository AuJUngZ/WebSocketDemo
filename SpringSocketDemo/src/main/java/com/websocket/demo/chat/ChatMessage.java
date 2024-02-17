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


    public static void SetCount(int i){
         count += i;
    }

    public void Setcountlana(){
        countLana = count;
    }

    @Getter
    private static int count = 0;
    private int countLana;
}
