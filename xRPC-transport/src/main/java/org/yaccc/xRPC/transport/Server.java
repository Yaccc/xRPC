package org.yaccc.xRPC.transport;

import java.io.IOException;

/**
 * Created by zhaodong on 16/2/5.
 */
public abstract class Server {
    /**
     * server start func
     * @throws Exception
     */
    public  abstract void start()throws Exception;

    /**
     * shutdown
     */
    public abstract void shutdown();
}
