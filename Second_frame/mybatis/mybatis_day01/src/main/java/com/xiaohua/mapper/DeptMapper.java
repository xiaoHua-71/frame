package com.xiaohua.mapper;

import com.xiaohua.entity.Dept;

import java.util.LinkedHashMap;
import java.util.List;

public interface DeptMapper {

    List<Dept> select(Dept dept);
    List<Dept> selectAll(Dept dept);
    List<Dept> select2(Dept dept);
}
