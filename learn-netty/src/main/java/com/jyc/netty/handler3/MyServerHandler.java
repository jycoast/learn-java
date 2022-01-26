package com.jyc.netty.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, PersonProtocol personProtocol) throws Exception {
        int length = personProtocol.getLength();
        byte[] content = personProtocol.getContent();
        System.out.println("服务端接收到的数据： ");
        System.out.println("长度: " + length);
        System.out.println("内容: " + new String(content, StandardCharsets.UTF_8));

        System.out.println("服务端收到的消息的数量: " + (++this.count));

        String responseMessage = UUID.randomUUID().toString();
        int responseLength = responseMessage.getBytes(StandardCharsets.UTF_8).length;
        byte[] responseContent = responseMessage.getBytes(StandardCharsets.UTF_8);

        PersonProtocol personProtocol1 = new PersonProtocol();
        personProtocol1.setLength(responseLength);
        personProtocol1.setContent(responseContent);
    }
}
