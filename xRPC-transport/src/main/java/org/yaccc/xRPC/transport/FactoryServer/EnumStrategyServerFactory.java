package org.yaccc.xRPC.transport.FactoryServer;

import com.google.common.base.Objects;
import org.yaccc.xRPC.transport.Server;
import org.yaccc.xRPC.transport.netty.NettyServer;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/12
 */
@Deprecated
public enum EnumStrategyServerFactory {
    NETTY("netty") {
        @Override
        public Server GetServer() {
            return new NettyServer();
        }
    },

    TOMCAT("tomcat") {
        @Override
        public Server GetServer() {
            return new Server() {
                @Override
                public void start() throws Exception {

                }

                @Override
                public void shutdown() {

                }

                @Override
                public String toString() {
                    return "tomcat";
                }
            };
        }
    };
    private String serverName;
//    private XRPCServicePublish.PublishModule publishModule;

    EnumStrategyServerFactory(String serverName) {
        this.serverName = serverName;
//        this.publishModule= publishModule;
    }

    public static EnumStrategyServerFactory of(String serverName) {
        EnumStrategyServerFactory[] values = EnumStrategyServerFactory.values();
        for (EnumStrategyServerFactory enumStrategyServerFactory : values) {
            if (Objects.equal(enumStrategyServerFactory.serverName, serverName)) {
                System.out.println(serverName);
                return enumStrategyServerFactory;
            }
        }
        return null;
    }

    public abstract Server GetServer();



}
