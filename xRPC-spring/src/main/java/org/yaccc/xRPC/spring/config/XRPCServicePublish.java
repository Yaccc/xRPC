package org.yaccc.xRPC.spring.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/11
 * service publish include registry or server choose or protcol choose and so on
 */
public class XRPCServicePublish implements FactoryBean, InitializingBean {
    //ip:port;
    private String location;
    //org.yaccc.xRPC.serialization.Serialization.JavaSerialization
    private String serializable;
    //interface and impl
    private String serviceInterface;
    private String serviceImpl;
    //netty? jetty? jetty? tomcat?
    private String serverImpl;



    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
