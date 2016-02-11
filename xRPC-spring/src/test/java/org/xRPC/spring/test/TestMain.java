package org.xRPC.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/11
 */
public class TestMain {


    @Test
  public   void testIoc() {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring-config.xml");
        String beanid = (String) applicationContext.getBean("beanid");
        System.out.println(beanid);
    }

}
