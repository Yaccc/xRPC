package org.yaccc.xRPC.transport.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.yaccc.xRPC.serialization.Serialization;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class RpcEncoder extends MessageToByteEncoder {
    public RpcEncoder(Serialization serialization, Class<?> clazz) {
        this.clazz = clazz;
        this.serialization = serialization;
    }

    private Serialization serialization;
    private Class<?> clazz;


    public Serialization getSerialization() {
        return serialization;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        Serialization.DataOutput outputObject = serialization.getDataOutputObject();
        byte[] bytes = outputObject.WriteToByte(msg);
        out.writeInt(bytes.length);
        out.writeBytes(bytes);
    }
}
