package org.yaccc.xRPC.transport.netty;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.yaccc.xRPC.transport.protocol.Request;
import org.yaccc.xRPC.transport.protocol.Response;

import java.net.SocketAddress;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/6
 */
public class NettyServerHander extends ChannelHandlerAdapter {
    private static final int STATUS_OK=200;
    private static final int STATUS_FAIL=500;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NettyServerHander.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Request request = (Request) msg;
        Response response=new Response();
        try {
            Object result = handle(request);
            response.setResult(result);
            response.setStatus(STATUS_OK);
        } catch (Throwable t) {
            t.printStackTrace();
            response.setStatus(STATUS_FAIL);
            response.setThrowable(t);

        }
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

    }

    private Object handle(Request req) throws Throwable {
        String className = req.getClassName();
        String methodName = req.getMethodName();
        Class<?>[] parameterTypes = req.getParameterTypes();
        Object[] parameters = req.getParameters();
        //new object
        Class<?> clazz = Class.forName(className);
        ConstructorAccess<?> constructorAccess = ConstructorAccess.get(clazz);
        Object invokeObject = constructorAccess.newInstance();
        //get method access
        MethodAccess methodAccess = MethodAccess.get(clazz);
        Object result = methodAccess.invoke(invokeObject, methodName, parameterTypes, parameters);

        return result;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        super.close(ctx, promise);
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        super.disconnect(ctx, promise);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        super.read(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);
    }
}
