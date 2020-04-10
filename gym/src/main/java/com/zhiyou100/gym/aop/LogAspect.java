package com.zhiyou100.gym.aop;

import com.zhiyou100.gym.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 输出日志
 * @author Sofia
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.zhiyou100.gym.mapper..*.updateById(..)) || execution(public * com.zhiyou100.gym.mapper..*.deleteById(..)) || execution(public * com.zhiyou100.gym.mapper..*.update(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] names = methodSignature.getParameterNames();
        Object[] objects = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            sb.append(names[i] + " = " + objects[i]);
            if (i != objects.length) {
                sb.append(", ");
            }
        }
        logger.info(user.getAccount()+":"+joinPoint.toString()+":"+sb.toString());
    }
}
