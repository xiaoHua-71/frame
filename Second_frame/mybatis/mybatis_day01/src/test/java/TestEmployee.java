import com.xiaohua.entity.Employee;
import com.xiaohua.mapper.EmployeeMapper;
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
 * @create: 2024-09-01 20:57
 **/
@Slf4j
public class TestEmployee {
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
    public void testSelect() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            try {
                List<Employee> employees = mapper.select(new Employee());
                for (Employee employee : employees) {
                    log.debug("id is [{}]",employee.getDept().getName());

                }

            }catch (Exception e){
                e.printStackTrace();
            }


        }
    }

    @Test
    public void testSelect2(){
        try (SqlSession session = sqlSessionFactory.openSession()){
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            try {
                List<Employee> select = mapper.select2(new Employee());


                log.debug("list is [{}]",select);
            }catch (Exception e){
                throw new RuntimeException("查询失败");
            }

        }


    }
}
