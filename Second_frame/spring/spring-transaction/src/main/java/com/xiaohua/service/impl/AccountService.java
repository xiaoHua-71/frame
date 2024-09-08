package com.xiaohua.service.impl;

import com.xiaohua.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-08 11:02
 **/
@Service
public class AccountService implements IAccountService {
    //执行数据库操作
    @Autowired
    JdbcTemplate jdbcTemplate ;

    //管理事务
    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public void transfer(String from, String to, Integer money) {
        //默认是事务配置
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //使用事务管理器管理事务
        TransactionStatus transaction = transactionManager.getTransaction(definition);

        try {
            //转账其实是两个语句
            String moneyFrom ="update account set money = money - ? where username = ?";
            int i = 1/0;
            String moneyTo ="update account set money = money + ? where username = ?";
            //从转账的人处扣钱
            jdbcTemplate.update(moneyFrom,money,from);
            jdbcTemplate.update(moneyTo,money,to);
        }catch (RuntimeException e){
            e.printStackTrace();
            //回滚，遇到异常就回滚
            transactionManager.rollback(transaction);
        }
        //没有异常就进行提交
        transactionManager.commit(transaction);

    }

    @Override
    public void transfer2(String from, String to, Integer money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                //转账其实是两个语句
                String moneyFrom ="update account set money = money - ? where username = ?";

                String moneyTo ="update account set money = money + ? where username = ?";
                //从转账的人处扣钱
                jdbcTemplate.update(moneyFrom,money,from);
//                int i = 1/0;
                jdbcTemplate.update(moneyTo,money,to);
            }
        });

    }

    @Override
    @Transactional
    public void transfer3(String from, String to, Integer money){
        //转账其实是两个语句
        String moneyFrom ="update account set money = money - ? where username = ?";

        String moneyTo ="update account set money = money + ? where username = ?";
        //从转账的人处扣钱
        jdbcTemplate.update(moneyFrom,money,from);
//        int i = 1/0;
        jdbcTemplate.update(moneyTo,money,to);
    }
}
