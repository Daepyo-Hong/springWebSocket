package com.green.nowon.messaging;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatBotController {

    @MessageMapping("/message")       // /app/hello로 요청이 되면 chatMessage()메서드 실행
    @SendTo("/topic/message")       // 리턴값을 페이지로 send
    public ChatMessage chatMessage(ChatClient client) throws Exception {
        Thread.sleep(1000);     // simulated delay
        return new ChatMessage("Hello, " + HtmlUtils.htmlEscape(client.getNickName()) + "!");
        //htmlEscape : 태그로들어오면 문자열 엔티티코드(&nbsp;)로 변환이될거에여
    }

}
