package com.jyc.netty.handler3;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyPersonEncoder extends MessageToByteEncoder<PersonProtocol> {

    @Override
    protected void encode(io.netty.channel.ChannelHandlerContext channelHandlerContext, PersonProtocol personProtocol, ByteBuf byteBuf) throws Exception {
        System.out.println("MyPersonEncoder encode invoked!");
        byteBuf.writeInt(personProtocol.getLength());
        byteBuf.writeBytes(personProtocol.getContent());
    }
}
