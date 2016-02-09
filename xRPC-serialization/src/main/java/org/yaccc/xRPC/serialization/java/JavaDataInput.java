package org.yaccc.xRPC.serialization.java;

import org.yaccc.xRPC.serialization.Serialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class JavaDataInput implements Serialization.DataInput {
    @Override
    public <O> O readToObject(byte[] bytes, Class<O> clazz) throws IOException, ClassNotFoundException {
        O o;
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
        //try with resources
       try( ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream)){
            o = (O) objectInputStream.readObject();
       }
        return o;
    }
}
