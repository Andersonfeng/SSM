/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.aop;

import org.aspectj.lang.JoinPoint;

/**
 * @author anderson
 */
public class LogHandler {

    public void beforeLog(JoinPoint jp) {
        Object[] args = jp.getArgs();
        for (Object obj : args) {
            if (obj instanceof String) {
                System.out.println("obj:" + obj);
            }
        }
        System.out.println("-----------------------------------beforeLog()-----------------------------------");
    }

    public void afterLog() {
        System.out.println("-----------------------------------afterLog()-----------------------------------");
    }
}
