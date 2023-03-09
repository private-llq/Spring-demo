package org.example.springdemo.service.section;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.section
 * @date 2022/12/11 18:03
 * @description: 公司
 */
@Component
@Aspect //定义切面
public class UserProxy {

    @Pointcut("execution(* org.example.springdemo.service.section.MayiktService.addUser(..));")
    private void pointcut(){

    }

    /**
     * 前置通知
     */
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("传入的参数值：args...[" + i + "]" + args[i]);
        }
        System.out.println("前置通知...");
    }

    /**
     * 后置通知
     */
    @After("pointcut()")
    public void after() {
        System.out.println("后置通知...");
    }

    /**
     * 环绕通知
     */
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知...");
        System.out.println("目标方法之前开始执行...");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("目标方法之后开始执行...");
        return result;
    }

    //@AfterReturning表达后置通知/返回通知,表达方法返回结果之后执行
    @AfterReturning(value = "pointcut()")
    public void afterReturning() {
        System.out.println("后置通知....afterReturning");
    }

    //@AfterThrowing表达异常通知
    @AfterThrowing(value = "pointcut()")
    public void afterThrowing() {
        System.out.println("异常通知....afterThrowing");
    }

}
