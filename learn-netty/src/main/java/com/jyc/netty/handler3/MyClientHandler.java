package com.jyc.netty.handler3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, PersonProtocol personProtocol) throws Exception {
        int length = personProtocol.getLength();
        byte[] content = personProtocol.getContent();
        System.out.println("客户端接收到的数据： ");
        System.out.println("长度: " + length);
        System.out.println("内容: " + new String(content, StandardCharsets.UTF_8));

        System.out.println("客户端收到的消息的数量: " + (++this.count));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String messageToBeSend = "send from client";
            byte[] content = messageToBeSend.getBytes(StandardCharsets.UTF_8);
            int length = messageToBeSend.getBytes(StandardCharsets.UTF_8).length;

            PersonProtocol personProtocol1 = new PersonProtocol();
            personProtocol1.setLength(length);
            personProtocol1.setContent(content);
            ctx.writeAndFlush(personProtocol1);
        }
    }
}
