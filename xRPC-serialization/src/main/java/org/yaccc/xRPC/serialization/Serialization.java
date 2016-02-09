package org.yaccc.xRPC.serialization;


import java.io.IOException;
import java.io.InvalidClassException;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/8
 */
public interface Serialization {
    /**
     * get datainput obecjt to serilization
     * @return DataInput
     */
    public DataInput getDataInputObject();

    /**
     *
     * @return DataOutput
     */
    public DataOutput getDataOutputObject();


    /**
     * write object to bytes
     */
    public interface DataOutput{
        /**
         *
         * @param obj object
         * @param <O>
         * @return binary bytes
         */
        public <O> byte[] WriteToByte(O obj)throws IOException,InvalidClassException;
    }

    /**
     * read bytes to object that class is belong to T
     */
    public interface DataInput{
        /**
         *
         * @param bytes binary bytes
         * @param clazz object class
         * @param <O>
         * @return object
         */
        public <O> O readToObject(byte[] bytes,Class<O> clazz) throws IOException,ClassNotFoundException;
    }
}
