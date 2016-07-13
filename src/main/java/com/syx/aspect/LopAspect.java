package com.syx.aspect;

import com.syx.controller.IndexController;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Administrator on 2016/7/10.
 */
@Aspect
@Component
public class LopAspect {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LopAspect.class);

    @Before("execution(* com.syx.controller.IndexController.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuilder sb = new StringBuilder();
        for (Object arg : joinPoint.getArgs()){
            sb.append("arg:" + arg.toString() + "|");
        }
        logger.info("before method: " + sb.toString());
    }

    @After("execution(* com.syx.controller.IndexController.*(..))")
    public void aftermethod(JoinPoint joinPoint){
        logger.info("after method: ");
    }
}
