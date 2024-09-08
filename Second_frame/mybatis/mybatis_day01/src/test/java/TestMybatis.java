import com.github.pagehelper.PageHelper;
import com.xiaohua.entity.User;
import com.xiaohua.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-29 20:47
 **/
@Slf4j
public class TestMybatis {

    SqlSessionFactory sqlSessionFactory =null;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //这个对象是核心一个工程的数据库相关的操作都是围绕sqlSessionFactory
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

    }

    @Test
    public void testSqlSession() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Object> objects = session.selectList("selectAll");
            log.debug("result is[{}]",objects);

        }

    }

    @Test
    public void testMapper() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectAll();
            log.debug("user is [{}]",users);
            System.out.println("---------------");

            SqlSession session2 = sqlSessionFactory.openSession();
            UserMapper mapper2 = session2.getMapper(UserMapper.class);
            //下面的数据是从缓存里面获取的
            List<User> users2 = mapper2.selectAll();
            log.debug("user is [{}]",users2);

        }

    }

    @Test
    public void testFindOne() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUserOne(1);
            log.debug("user is [{}]",user);

        }
    }

    @Test
    public void testSelect() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.select("itnanls","123456");
            log.debug("user is [{}]",user);

        }
    }

    @Test
    public void testFindByMap()  {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
            Map<String,Object> param = new HashMap<>(2);
            param.put("username","idnamls");
            param.put("password","123");
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectByMap(param);
            log.debug("user is [{}]",user);

        }
    }

    @Test
    public void testFindByUsername()  {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
            UserMapper mapper = session.getMapper(UserMapper.class);
            PageHelper.startPage(1,3);
            List<User> users = mapper.selectByUsername("%"+ "x" +"%");
            log.debug("user is [{}]",users);

        }
    }

    @Test
    public void testInsert()  {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
            try {
                UserMapper mapper = session.getMapper(UserMapper.class);
                User user = new User(1,"xiaohua","123456");
                int affectedRows = mapper.insert(user);
                log.debug("affectedRows is [{}]",affectedRows);

                log.debug("id is [{}]",user.getId());
                //提交事务
//                int i = 1/0;
                session.commit();
            }catch (Exception e){
                log.error("当前状态不太好，请再来谈一次",e);
                session.rollback();
            }


        }
    }

    @Test
    public void testUpdate()  {
        //传入true就是自动提交
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            //statement是sql的声明
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
                UserMapper mapper = session.getMapper(UserMapper.class);
                int affectedRows = mapper.update(new User(122,"xiaohua11",null));
                log.debug("affectedRows is [{}]",affectedRows);
        }
    }
    @Test
    public void testDelete()  {
        //传入true就是自动提交
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            //statement是sql的声明
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
            UserMapper mapper = session.getMapper(UserMapper.class);
            int affectedRows = mapper.delete(123);
            log.debug("affectedRows is [{}]",affectedRows);
        }
    }

    @Test
    public void testSelectByUser() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            UserMapper mapper = session.getMapper(UserMapper.class);
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
            User param = new User(null,"ydlclass",null);
            List<User> users = mapper.selectByUser(param);
            log.debug("user is [{}]",users);

        }

    }

    @Test
    public void testDeleteByIds() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            UserMapper mapper = session.getMapper(UserMapper.class);
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口

            int affectedRows = mapper.deleteByIds(List.of(1,2,3,4,5));
            log.debug("user is [{}]",affectedRows);

        }

    }

    @Test
    public void testSelectByIds() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            UserMapper mapper = session.getMapper(UserMapper.class);
            //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口

            List<User> users = mapper.selectByIds(List.of(1,122,3,4,5));
            log.debug("user is [{}]",users);

        }

    }

    @Test
    public void batchInsert() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            UserMapper mapper = session.getMapper(UserMapper.class);
            try {
                //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
                List<User> users1 = List.of(
                        new User(null, "tt", "123456"),
                        new User(null, "tt1", "123456"),
                        new User(null, "tt2", "123456")
                );

                int i = mapper.batchInsert(users1);
                log.debug("user is [{}]",i);
//                int ih = 1/0;
                session.commit();
            }catch (Exception e){
                e.printStackTrace();
                session.rollback();

            }
        }
    }


    @Test
    public void batchDeleteByIds() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //statement是sql的声明
            UserMapper mapper = session.getMapper(UserMapper.class);
            try {
                //获得一个代理对象，使用的是jdk的proxy类，代理对象实现了UserMapper接口
                int i = mapper.batchDeleteByIds(List.of(130,131,132,133,134,135));
                log.debug("user is [{}]",i);
//                int ih = 1/0;
                session.commit();
            }catch (Exception e){
                e.printStackTrace();
                session.rollback();

            }
        }
    }





    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();

        StringBuilder sb = new StringBuilder("select * from user");

        SQL sql = new SQL();
        sql.SELECT("id","username","password").
                FROM("user").WHERE("id = 1");
        System.out.println(sql);

    }


}
