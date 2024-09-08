package com.xiaohua.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-08 12:53
 **/

public class TxAdvice implements MethodInterceptor {

    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public Object invoke(MethodInvocation methInvocation) throws Throwable {
        //默认是事务配置
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //使用事务管理器管理事务
        TransactionStatus transaction = transactionManager.getTransaction(definition);
        Object returnVal = null;
        try {
            returnVal = methInvocation.getMethod().invoke(
                    methInvocation.getThis(),
                    methInvocation.getArguments()
            );

        } catch (RuntimeException e) {
            e.printStackTrace();
            //回滚，遇到异常就回滚
            transactionManager.rollback(transaction);

//            throw new RuntimeException("遇到了问题请下次再来");
        }
        //没有异常就进行提交
        transactionManager.commit(transaction);
        return returnVal;
    }

}
