package org.yaccc.xRPC.spring.config;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.yaccc.xRPC.serialization.Serialization;
import org.yaccc.xRPC.transport.Server;
import org.yaccc.xRPC.transport.netty.NettyServer;


import java.net.InetSocketAddress;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/11
 * service publish include registry or server choose or protcol choose and so on
 */
public class XRPCServicePublish implements FactoryBean, InitializingBean,ApplicationContextAware {
    //ip:port;
    private String location;
    //eg: org.yaccc.xRPC.serialization.Serialization.JavaSerialization
    private Serialization serializable;
    //interface and impl
    private String serviceInterface;
    private Object serviceImpl;
    //netty? jetty? jetty? tomcat?

    private Server serverimpl;


    @Override
    public Object getObject() throws Exception {
        return this;
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * bean init
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        String[] locations = location.split(":");
        String ip = locations[0];
        int port = Integer.parseInt(locations[1]);
        serverimpl = NettyServer.creater()
                .serialization(serializable)
                .socketAddress(new InetSocketAddress(ip, port))
                .creat();
        serverimpl.start();
    }

    public void destory(){
        System.out.println("close");
        if(serverimpl!=null)
            serverimpl.shutdown();
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setSerializable(Serialization serializable) {
        this.serializable = serializable;
    }

    public void setServiceInterface(String serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public void setServiceImpl(Object serviceImpl) {
        this.serviceImpl = serviceImpl;
    }
    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
