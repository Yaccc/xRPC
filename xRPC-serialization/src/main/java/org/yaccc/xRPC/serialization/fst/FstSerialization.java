package org.yaccc.xRPC.serialization.fst;

import org.nustaq.serialization.FSTConfiguration;
import org.yaccc.xRPC.serialization.Serialization;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class FstSerialization implements Serialization {
    static FSTConfiguration fstConfiguration=FSTConfiguration.createDefaultConfiguration();
    @Override
    public DataInput getDataInputObject() {
        return  new FstDataInput();
    }

    @Override
    public DataOutput getDataOutputObject() {
        return new FstDataOutput();
    }
}
