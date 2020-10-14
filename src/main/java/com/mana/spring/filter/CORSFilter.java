package com.mana.spring.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class  CORSFilter implements Filter {

    public CORSFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("CORSFilter HTTP Request: " + request.getMethod());

        // Authorize (allow) domains to consume the content
//        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "http://admin.dzicreations.com");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");

        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Credentials", "true");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if (request.getMethod().equals("OPTIONS")) {
            resp.setStatus(HttpServletResponse.SC_OK);
            System.out.println("OPTIONS HttpServletResponse: " + HttpServletResponse.SC_OK);
            return;
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
