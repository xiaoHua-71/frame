import com.xiaohua.entity.Dept;
import com.xiaohua.entity.Employee;
import com.xiaohua.mapper.DeptMapper;
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
public class TestDept {
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
    public void testSelectAll(){
        try (SqlSession session = sqlSessionFactory.openSession()){
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            try {
                List<Dept> depts = mapper.selectAll(new Dept());


                log.debug("list is [{}]",depts);
            }catch (Exception e){
                throw new RuntimeException("查询失败");
            }

        }


    }

    @Test
    public void testSelect2(){
        try (SqlSession session = sqlSessionFactory.openSession()){
            DeptMapper mapper = session.getMapper(DeptMapper.class);
            try {
                List<Dept> depts = mapper.select2(new Dept());


                log.debug("list is [{}]",depts);
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }


}
