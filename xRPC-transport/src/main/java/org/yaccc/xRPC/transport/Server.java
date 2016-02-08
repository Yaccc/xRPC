package org.yaccc.xRPC.transport;

import java.io.IOException;

/**
 * Created by zhaodong on 16/2/5.
 */
public interface Server {
    /**
     * server start func
     * @throws Exception
     */
    public void start()throws Exception;

    /**
     * shutdown
     */
    public void shutdown();
}
