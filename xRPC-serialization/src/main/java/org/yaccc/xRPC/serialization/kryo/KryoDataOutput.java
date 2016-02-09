package org.yaccc.xRPC.serialization.kryo;

import org.yaccc.xRPC.serialization.Serialization;

import java.io.IOException;
import java.io.InvalidClassException;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class KryoDataOutput implements Serialization.DataOutput {

    @Override
    public <O> byte[] WriteToByte(O obj) throws IOException,InvalidClassException {
        return new byte[0];
    }
}
