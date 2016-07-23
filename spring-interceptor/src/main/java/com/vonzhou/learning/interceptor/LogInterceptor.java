package com.vonzhou.learning.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-handlermapping-interceptor
 * Created by vonzhou on 16/7/22.
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = Logger.getLogger(LogInterceptor.class);

    //  Intercept the execution of a handler.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        if(!isValidUser()){
            logger.info("Invalid user from " + request.getRemoteAddr());
            response.sendRedirect("http://localhost:8888/user/error");
            return false;
        }

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        logger.info("Will call " + handler.toString());


//        response.getWriter().println(" --- From Interceptor, you are rejected.");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("before return view  page, i can get model = " + modelAndView.getModelMap().get("hello"));
    }

    // Callback after completion of request processing, that is, after rendering the view.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Our Log Func
        long curTime = System.currentTimeMillis();
        long startTime = (Long)request.getAttribute("startTime");
        long cost = curTime - startTime;
        logger.info("Call cost time " + cost + " mills!");
    }

    // FAKE
    private boolean isValidUser(){
        return true;
    }
}