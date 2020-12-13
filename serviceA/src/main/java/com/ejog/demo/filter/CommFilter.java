package com.ejog.demo.filter;

import com.ejog.demo.model.Stat;
import org.apache.logging.log4j.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter("/*")
public class CommFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger();
    private final Level CHECK = Level.forName("CHECK",550);

    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        long time = System.currentTimeMillis();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            time = System.currentTimeMillis() - time;
            Stat.countRequests(time);
            LOGGER.log(CHECK, "Host: "+httpRequest.getHeader("Host")
                    + " - Remote User:"   + httpRequest.getRemoteAddr()
                    + " - URI:" + httpRequest.getRequestURI()
                    + " - Req/Resp Time:" +time);
        }
    }

    @Override
    public void destroy() {
    }

}
