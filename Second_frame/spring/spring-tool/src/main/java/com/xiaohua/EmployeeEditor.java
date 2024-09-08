package com.xiaohua;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 11:20
 **/

public class EmployeeEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Employee employee = new Employee();
        employee.setName(text);
        employee.setSalary(100000F);
        super.setValue(employee);

    }
}
