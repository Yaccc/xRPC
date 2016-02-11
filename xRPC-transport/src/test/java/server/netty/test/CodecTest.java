package server.netty.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.yaccc.xRPC.serialization.fst.FstSerialization;
import org.yaccc.xRPC.serialization.java.JavaSerialization;
import org.yaccc.xRPC.transport.netty.RpcDecoder;
import org.yaccc.xRPC.transport.netty.RpcEncoder;
import org.yaccc.xRPC.transport.protocol.Request;
import org.yaccc.xRPC.transport.protocol.Response;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class CodecTest extends SimpleChannelInboundHandler {

    public void start() {

       final FstSerialization fstSerialization=new FstSerialization();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new RpcEncoder(fstSerialization,Request.class)); // 将 RPC 响应进行解码（为了处理响应）
                            channel.pipeline().addLast(new RpcDecoder(fstSerialization,Response.class));
                            channel.pipeline().addLast(CodecTest.this); // 使用 RpcClient 发送 RPC 请求
                        }
                    })
                    .option(ChannelOption.SO_KEEPALIVE, true);

            try {
                ChannelFuture future = bootstrap.connect("127.0.0.1", 9000).sync();
                Request request=new Request();
                request.setRequestId("121221");
                request.setClassName("server.netty.test.InvokeClass");
                request.setMethodName("say");
                request.setParameterTypes(new Class[]{String.class,int.class});
                request.setParameters(new Object[]{"xiezhaodong",23});
//                NettyServerHander.person person=new NettyServerHander.person();
//                person.setName("xiezhaodong");
//                person.setAge(123);
                future.channel().writeAndFlush(request).sync();
                future.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            group.shutdownGracefully();
        }

    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        Response response= (Response) msg;
        System.out.println(response);
    }

    public static void main(String[] args) {
        CodecTest codecTest = new CodecTest();
        codecTest.start();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
    }




}
