/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author anderson
 */
@Component
@Aspect
public class LogHandler {
    Logger logger = Logger.getLogger("");

    @Pointcut("execution(* demo.anderson.controller.*.*(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void beforeLog(JoinPoint jp) {
        Object[] args = jp.getArgs();
        for (Object obj : args) {
            if (obj instanceof String) {
                logger.info("obj:" + obj);
//                System.out.println("obj:" + obj);
            }
        }
        logger.info("---beforeLog()---");
    }
    @After("pointCut()")
    public void afterLog() {
        logger.info("---afterLog()---");
    }

}
