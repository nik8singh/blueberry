package com.mana.spring.web.auth;

import com.mana.spring.util.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        response.getWriter().write(jwtTokenUtil.generateToken());
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.getWriter().flush();
    }
}
