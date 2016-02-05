package server.netty.test;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;
import org.yaccc.xRPC.transport.netty.NettyServer;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/6
 */
public class NettyServerTest {



    @Test
    public void serverStart() throws Exception {

        NettyServer nettyServer=NettyServer.creater().bossGroup(new NioEventLoopGroup()).workerGroup(new NioEventLoopGroup())
                .socketAddress(new InetSocketAddress("127.0.0.1",9000)).channelType(NioServerSocketChannel.class).creat();
        nettyServer.start();

    }

    public static void main(String[] args) throws Exception {

        NettyServer nettyServer=NettyServer.creater().bossGroup(new NioEventLoopGroup()).workerGroup(new NioEventLoopGroup())
                .socketAddress(new InetSocketAddress("127.0.0.1",9000)).channelType(NioServerSocketChannel.class).creat();
        nettyServer.start();
        Thread.sleep(2000);
        System.out.println("123");

        Socket socket=new Socket("127.0.0.1",9000);
        socket.getOutputStream().write("xiezhaodong".getBytes());

    }
}
