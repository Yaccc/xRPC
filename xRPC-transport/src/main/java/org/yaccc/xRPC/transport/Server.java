package org.yaccc.xRPC.transport;

import java.io.IOException;

/**
 * Created by zhaodong on 16/2/5.
 */
public interface Server {

    public void start()throws Exception;

    public void shutdown();
}
