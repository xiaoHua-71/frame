package com.xiaohua;

import com.xiaohua.service.IAccountService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-08 11:06
 **/
public class AccountTest {
    private final static Logger log = LoggerFactory.getLogger(AccountTest.class);

    @Test
    public void testTransfer(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("tx.xml");
        IAccountService accountService = ctx.getBean(IAccountService.class);
        accountService.transfer("huahua","tiantain",200);


    }
    @Test
    public void testTransfer2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("tx.xml");
        IAccountService accountService = ctx.getBean(IAccountService.class);
        accountService.transfer2("huahua","tiantain",200);
    }
    @Test
    public void testTransfer3() throws FileNotFoundException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("tx.xml");
        IAccountService accountService = ctx.getBean(IAccountService.class);
        accountService.transfer3("huahua","tiantain",200);
    }

    @Test
    public void testTransfer4() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        IAccountService accountService = ctx.getBean(IAccountService.class);
        accountService.transfer3("huahua","tiantain",200);
    }
}
