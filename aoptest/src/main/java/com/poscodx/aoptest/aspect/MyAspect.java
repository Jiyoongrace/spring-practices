package com.poscodx.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Before("execution(public com.poscodx.aoptest.vo.ProductVo com.poscodx.aoptest.service.ProductService.find(String))")
    public void adviceBefore() {
        System.out.println("--- Before Advice ---");
    }

    @After("execution(com.poscodx.aoptest.vo.ProductVo com.poscodx.aoptest.service.ProductService.find(String))")
    public void adviceAfter() {
        System.out.println("--- After Advice ---");
    }

    @AfterReturning("execution(* com.poscodx.aoptest.service.ProductService.find(..))")
    public void adviceAfterReturning() {
        System.out.println("--- AfterReturning Advice ---");
    }

    @AfterThrowing(value = "execution(* *..*.*.*(..))", throwing = "ex")
    public void adviceAfterThrowing(Throwable ex) {
        System.out.println("--- AfterThrowing Advice ---" + ex + "---");
    }

    @Around("execution(* *..*.ProductService.*(..))")
    public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable { // 지금 실행되고 있는 메서드 정보
        /* Before */
        System.out.println("--- Around(Before) ---");

        /* Point Cut Method */
        // Object[] params = {"Camera"};
        // Object result = pjp.proceed(params); // find()

        Object result = pjp.proceed(); // find()

        /* After */
        System.out.println("--- Around(After) ---");

        return result;
    }
}
