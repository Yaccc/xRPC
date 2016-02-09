package org.yaccc.xRPC.serialization.fst;

import com.google.common.base.Preconditions;
import org.yaccc.xRPC.serialization.Serialization;

import java.io.IOException;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class FstDataInput implements Serialization.DataInput {
    @Override
    public <O> O readToObject(byte[] bytes, Class<O> clazz) throws IOException, ClassNotFoundException {
        Preconditions.checkNotNull(clazz);
        return (O) FstSerialization.fstConfiguration.asObject(bytes);
    }
}
