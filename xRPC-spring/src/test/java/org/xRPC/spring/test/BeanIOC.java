package org.xRPC.spring.test;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/11
 */
public class BeanIOC implements FactoryBean<String> {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getObject() throws Exception {
        return name;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
