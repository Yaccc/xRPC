package org.yaccc.xRPC.commoms.Utils;

import com.google.common.base.Preconditions;

/**
 * Created by zhaodong on 16/1/20.
 * some string utils
 */

public final class CommomUtils {

    private CommomUtils(){}
    /**
     * if origin ==null then will return default value.
     *
     * @param origin
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T nullDefault(T origin,T defaultValue){
        Preconditions.checkNotNull(defaultValue,"default value must not be null");
        return origin==null?defaultValue:origin;
    }
}
