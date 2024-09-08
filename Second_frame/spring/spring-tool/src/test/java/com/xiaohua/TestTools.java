package com.xiaohua;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 10:56
 **/

public class TestTools {

    private static final Logger logger =  LoggerFactory.getLogger(TestTools.class);
    @Test
    public void testBeanWrapper(){
        Company company = new Company();
        Employee employee = new Employee();

        //将实例进行包装
        BeanWrapper beanWrapper = new BeanWrapperImpl(company);

        beanWrapper.setPropertyValue("name","XiaoHua");

        beanWrapper.setPropertyValue("managingDirector",new Employee());

        beanWrapper.setPropertyValue("managingDirector.name","lilaoshi");

        beanWrapper.setPropertyValue("managingDirector.salary","1000000");

        System.out.println(beanWrapper.getWrappedInstance());

    }

    @Test
    public void testProperEditor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Company bean = context.getBean(Company.class);
        logger.info("{}",bean);


    }

    @Test
    public void testConvertor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Employee bean = context.getBean(Employee.class);
        logger.info("{}",bean);


    }
    @Test
    public void testDataBinder(){
        //验证employee的员工的一些信息
        Employee employee = new Employee();
        employee.setSalary(1500);
        //绑定的是数据和校验规则
        DataBinder dataBinder = new DataBinder(employee);
        dataBinder.addValidators(new EmployeeValidate());
        dataBinder.validate();
        //这里会存放验证结果
        BindingResult bindingResult = dataBinder.getBindingResult();

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            System.out.println(error);
        }

    }
    @Test
    public void testEl(){
        ExpressionParser parser  = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello el'");
        //获取解析过的结果
        System.out.println(expression.getValue());
        //

        expression = parser.parseExpression("'hello el'.concat('!')");
        //获取解析过的结果
        System.out.println(expression.getValue());

        expression = parser.parseExpression("'hello el'.bytes.length");
        //获取解析过的结果
        System.out.println(expression.getValue());

        expression = parser.parseExpression("new String('hello world').toUpperCase()");
        //获取解析过的结果
        System.out.println(expression.getValue());


        Employee employee = new Employee();
        employee.setName("lucy");
        expression = parser.parseExpression("name"); // Parse name as an expression
        String name = (String) expression.getValue(employee);
        System.out.println(name);

    }

    @Test
    public void testValue(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(User.class);
        Environment environment = applicationContext.getEnvironment();
        User bean = applicationContext.getBean(User.class);
        logger.info("{}",bean);

    }

    @Test
    public void testEl2(){
        //这个是spring给我们提供的一个el表达式的上下文
        EvaluationContext context = (EvaluationContext) SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Inventor tesla = new Inventor();
        tesla.setInventions(new String[]{"电话","飞机"});
        ExpressionParser parser  = new SpelExpressionParser();
        String invenion = (String) parser.parseExpression("Inventions[0]").getValue(tesla);
        System.out.println(invenion);




    }
}
