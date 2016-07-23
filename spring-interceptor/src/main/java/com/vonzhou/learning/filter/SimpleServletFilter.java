package com.vonzhou.learning.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vonzhou on 16/7/23.
 */
public class SimpleServletFilter implements Filter{
    private static Logger logger = Logger.getLogger(SimpleServletFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("SimpleServletFilter init....");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String id = request.getParameter("id");
        if(id != null && !id.isEmpty() && !id.equals("123")){
            chain.doFilter(request,response);
        }

        // Reply directly here
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.getWriter().println("+++ From Filter, Another Page...enjoy");
    }

    public void destroy() {
        logger.info("SimpleServletFilter destroy....");
    }
}
