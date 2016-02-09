package org.yaccc.xRPC.transport.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.yaccc.xRPC.serialization.Serialization;
import java.util.List;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class RpcDecoder extends ByteToMessageDecoder {
    public RpcDecoder(Serialization serialization, Class<?> clazz) {
        this.clazz = clazz;
        this.serialization = serialization;
    }

    private Serialization serialization;
    private Class<?> clazz;


    public void setSerialization(Serialization serialization) {
        this.serialization = serialization;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (dataLength < 0) {
            ctx.close();
        }
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        System.out.println(data.length);
        Serialization.DataInput inputObject = serialization.getDataInputObject();
        Object o = inputObject.readToObject(data,clazz);
        out.add(o);
    }
}
