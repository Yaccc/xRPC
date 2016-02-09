package org.yaccc.xRPC.serialization.java;

import org.yaccc.xRPC.serialization.Serialization;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class JavaSerialization implements Serialization {
    @Override
    public DataInput getDataInputObject() {
        return new JavaDataInput();
    }

    @Override
    public DataOutput getDataOutputObject() {
        return new JavaDataOutput();
    }
}
