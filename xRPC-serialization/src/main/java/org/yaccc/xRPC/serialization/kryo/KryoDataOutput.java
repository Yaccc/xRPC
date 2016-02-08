package org.yaccc.xRPC.serialization.kryo;

import org.yaccc.xRPC.serialization.Serialization;

import java.io.IOException;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class KryoDataOutput implements Serialization.DataInput {
    @Override
    public <O> O readToObject(byte[] bytes, Class<O> clazz) throws IOException, ClassNotFoundException {
        return null;
    }
}
