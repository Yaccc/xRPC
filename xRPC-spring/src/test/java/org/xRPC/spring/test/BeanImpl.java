package org.xRPC.spring.test;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/12
 */
public class BeanImpl implements BeanIOC {
    @Override
    public String say(String name, int age) {
        return name+age;
    }
}
