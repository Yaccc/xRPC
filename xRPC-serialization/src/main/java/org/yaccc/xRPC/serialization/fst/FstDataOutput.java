package org.yaccc.xRPC.serialization.fst;

import org.yaccc.xRPC.serialization.Serialization;

import java.io.IOException;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class FstDataOutput implements Serialization.DataOutput {


    @Override
    public <O> byte[] WriteToByte(O obj) throws IOException {
        return   FstSerialization.fstConfiguration.asByteArray(obj);

    }
}
