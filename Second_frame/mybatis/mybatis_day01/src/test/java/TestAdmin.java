import com.xiaohua.entity.Admin;
import com.xiaohua.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-30 22:11
 **/
@Slf4j
public class TestAdmin {
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
        try (SqlSession session = sqlSessionFactory.openSession(true)) {

            AdminMapper mapper = session.getMapper(AdminMapper.class);
            List<Admin> allAdmins = mapper.findAllAdmins();
            log.debug("allAdmins are[{}]",allAdmins);
        }

    }

    @Test
    public void testSelectById() {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {

            AdminMapper mapper = session.getMapper(AdminMapper.class);
            Admin allAdmins = mapper.findAdminById(1);
            log.debug("allAdmins are[{}]",allAdmins);
        }

    }
}
