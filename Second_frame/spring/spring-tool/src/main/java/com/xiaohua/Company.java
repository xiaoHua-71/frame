package com.xiaohua;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 10:52
 **/

public class Company {
    private String name;
    private Employee managingDirector;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManagingDirector() {
        return this.managingDirector;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", managingDirector=" + managingDirector +
                '}';
    }
}
