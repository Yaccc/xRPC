package org.xRPC.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/11
 */
public class TestMain {



  public   void testIoc() throws IOException {

      ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring-config.xml");


    }

    public static void main(String[] args) throws IOException {

        TestMain testMain=new TestMain();
        testMain.testIoc();
    }

}
