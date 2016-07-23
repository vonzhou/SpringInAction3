package com.vonzhou.spitter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vonzhou on 16/7/22.
 */
@Component
@Aspect
public class SpittleAspect {
    private static final Logger logger = LoggerFactory.getLogger(SpittleAspect.class);

    // 对所有controller的监控
    @Around("execution(* org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handle(..))")
//    @Around(value = "@within(org.springframework.stereotype.Controller)")
    public Object aa(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("++++++++++++");
        try {
            Object[] args = pjp.getArgs();
            String requestUrl = null, params = null, requestMethod = null;
            for (Object obj : args) {
                if (obj instanceof DefaultMultipartHttpServletRequest) {
                    DefaultMultipartHttpServletRequest request = (DefaultMultipartHttpServletRequest) obj;
                    requestUrl = request.getRequestURL().toString();
                    params = request.getParameterMap().keySet() + "-" + request.getMultiFileMap().keySet();
                    requestMethod = request.getMethod();
                    break;
                } else if (obj instanceof HttpServletRequest) {
                    HttpServletRequest request = (HttpServletRequest) obj;
                    requestUrl = request.getRequestURL().toString();
                    params = request.getParameterMap().keySet() + "";
                    requestMethod = request.getMethod();
                    break;
                }
            }

            logger.info("call {}, param: {} requestMethod: {}", new Object[]{requestUrl, params, requestMethod});

            return pjp.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("maybe error for request param, detail: " + e.getMessage());
            return null;
        }
    }
}
