package com.vonzhou.learning.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.Calendar;

import static java.util.Calendar.HOUR_OF_DAY;

/**
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-handlermapping-interceptor
 * Created by vonzhou on 16/7/22.
 */
public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {

    private int openingTime;
    private int closingTime;

    private static Logger logger = Logger.getLogger(TimeBasedAccessInterceptor.class);

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("--- in preHandle ---");
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(HOUR_OF_DAY);
        if (openingTime <= hour && hour < closingTime) {
            logger.info("--- is office hour ---");
            return true;
        }
        response.sendRedirect("http://localhost:8888/office/error");

        return false;
    }


}