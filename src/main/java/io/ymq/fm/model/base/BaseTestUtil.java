package io.ymq.fm.model.base;

import io.ymq.fm.run.Startup;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述: 基础测试类
 *
 * @author yanpenglei
 * @create 2017-09-08 18:14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
public class BaseTestUtil {

    @Before
    public void before(){

        System.out.println("测试开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @After
    public void after() {

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<测试完成");
    }




}
