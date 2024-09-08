package com.xiaohua;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 12:19
 **/

public class EmployeeValidate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if (employee.getSalary() < 2000){
            errors.rejectValue("salary","10001","员工的最低薪资标志是2000，但是你的是" +employee.getSalary());
        }
    }
}
