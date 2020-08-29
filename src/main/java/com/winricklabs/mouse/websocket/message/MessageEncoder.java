package com.winricklabs.mouse.websocket.message;

import com.google.gson.Gson;

public class MessageEncoder  {
    private static Gson gson = new Gson();

    public String encode(Message message) {
        return gson.toJson(message);
    }
}
