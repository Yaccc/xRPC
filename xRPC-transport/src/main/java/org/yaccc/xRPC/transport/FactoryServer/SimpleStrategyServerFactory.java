package org.yaccc.xRPC.transport.FactoryServer;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import org.yaccc.xRPC.transport.Server;
import org.yaccc.xRPC.transport.protocol.PublishModule;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/12
 */
@Deprecated
public final class SimpleStrategyServerFactory {
    private SimpleStrategyServerFactory() {
    }

    public static Server GetServer(String clazzName, PublishModule publishModule) throws ClassNotFoundException {
        Class<?> clazz;
        try {
            clazz = Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(clazzName + " not found");
        }
        ConstructorAccess access = ConstructorAccess.get(clazz);
        Object o = access.newInstance();

        return null;
    }


}
