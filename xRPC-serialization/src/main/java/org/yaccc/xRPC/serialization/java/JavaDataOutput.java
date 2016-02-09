package org.yaccc.xRPC.serialization.java;

import org.yaccc.xRPC.serialization.Serialization;

import java.io.IOException;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class JavaDataOutput implements Serialization.DataOutput {
    @Override
    public <O> byte[] WriteToByte(O obj) throws IOException {
        return new byte[0];
    }
}
