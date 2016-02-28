package org.yaccc.xRPC.transport.protocol;
@Deprecated
public  class PublishModule {
        private String ip;
        private String port;
        private String serializable;

        @java.beans.ConstructorProperties({"ip", "port", "serializable"})
        private PublishModule(String ip, String port, String serializable) {
            this.ip = ip;
            this.port = port;
            this.serializable = serializable;
        }

        public static PublishModule of(String ip, String port, String serializable) {
            return new PublishModule(ip, port, serializable);
        }


        public String getIp() {
            return this.ip;
        }

        public String getPort() {
            return this.port;
        }

        public String getSerializable() {
            return this.serializable;
        }


        public String toString() {
            return "org.yaccc.xRPC.spring.config.XRPCServicePublish.PublishModule(ip=" + this.ip + ", port=" + this.port + ", serializable=" + this.serializable + ")";
        }
}