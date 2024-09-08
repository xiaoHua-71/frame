import com.xiaohua.*;
import com.xiaohua.datasource.DataSourceConfig;
import com.xiaohua.env.MyPropertySource;
import com.xiaohua.factorybean.DataSourceFactoryBean;
import com.xiaohua.listener.*;
import com.xiaohua.service.OrderService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import javax.sql.DataSource;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-03 18:52
 **/
public class testIoc {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Test
    public void testIoc(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.hello();
    }

    @Test
    public void testStaticFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) context.getBean("userService");
        log.info(userService.toString());

    }


    //使用构造器注入获取dao
    @Test
    public void testConstructor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) context.getBean("userService");
        log.info(userService.toString());

    }
    //user对象
    @Test
    public void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        User user = (User) context.getBean("user");
        log.info(user.toString());

    }

    //user对象
    @Test
    public void testAutoWired(){
        ApplicationContext context = new ClassPathXmlApplicationContext("autowired.xml");
        User user = (User) context.getBean("user");
        log.info(user.toString());

    }

    @Test
    public void testCycle(){
        ApplicationContext context = new ClassPathXmlApplicationContext("cycle.xml");
        A a = (A) context.getBean("a");
        A a1 = (A) context.getBean("a");
        log.info("{}",a == a1);
        B b = (B) context.getBean("b");
        log.info(b.toString());

    }
    @Test
    public void testLifeCycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");
//        Address address = (Address) context.getBean("address");
        A a = context.getBean(A.class);
        log.info("{}",a);
        context.close();

    }

    @Test
    public void testAware(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aware.xml");
//        Address address = (Address) context.getBean("address");
        C c = context.getBean(C.class);
        c.printName();
        log.info("{}",c);

        context.close();

    }

    @Test
    public void testAnnotation(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        Boy boy = context.getBean(Boy.class);
        log.info("{}",boy);

        context.close();

    }

    @Test
    public void testScan(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scan.xml");
        OrderService orderService = context.getBean(OrderService.class);
        log.info("{}",orderService);

        context.close();

    }
    @Test
    public void testAppConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);

        log.info("{}",orderService);

        context.close();

    }

    @Test
    public void testFacrotyBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceFactoryBean.class);
        DataSource bean = context.getBean(DataSource.class);
        System.out.println(bean);

    }

    @Test
    public void testProfile(){
        //创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //激活环境
        context.getEnvironment().setActiveProfiles("prod");
        //扫包
        context.scan("com.com.xiaohua.datasource");
        //刷新
        context.refresh();

        DataSourceConfig bean = context.getBean(DataSourceConfig.class);
        System.out.println(bean);

    }


    @Test
    public void testEnv(){
        //创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //激活环境
        ConfigurableEnvironment environment = context.getEnvironment();

        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new MyPropertySource("my"));
        context.refresh();
        //使用
        String hello = environment.getProperty("hello");
        log.info(hello);

    }

    @Test
    public void MyConfig(){
        //创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class,F.class);
        //激活环境
        F bean = context.getBean(F.class);
        System.out.println(bean);

    }

    @Test
    public void MyListener(){
        //创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageListener.class, EmailListener.class, EmailListener2.class,ContextFinish.class);
        //激活环境
//        context.publishEvent(new OrderEvent(new Order("123434","jerry")));

    }





}
