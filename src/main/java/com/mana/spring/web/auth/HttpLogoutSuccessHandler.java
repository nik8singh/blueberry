package com.mana.spring.web.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        System.out.println("Success Login");
        System.out.println(response.toString());
        System.out.println(authentication.getDetails());
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().flush();
    }
}
