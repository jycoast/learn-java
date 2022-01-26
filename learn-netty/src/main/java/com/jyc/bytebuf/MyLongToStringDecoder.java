package com.jyc.bytebuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class MyLongToStringDecoder extends MessageToMessageDecoder<Long> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Long aLong, List<Object> list) throws Exception {
        System.out.println("MyLongToStringDecoder decode invoked!");
        list.add(aLong.toString());
    }
}
