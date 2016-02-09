package org.yaccc.xRPC.serialization.java;


import org.slf4j.Logger;
import org.yaccc.xRPC.serialization.Serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class JavaDataOutput implements Serialization.DataOutput {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JavaDataOutput.class);

    @Override
    public <O> byte[] WriteToByte(O obj) throws IOException,InvalidClassException {
        //is serialization?
        if(obj  instanceof Serializable){
            log.info("object are Serializable");
        }else{
            throw new InvalidClassException(obj.getClass()+" are should be implement Serializable interface");
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
        return bos.toByteArray();
    }




}
