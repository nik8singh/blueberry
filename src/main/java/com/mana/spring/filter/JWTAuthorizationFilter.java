package com.mana.spring.filter;

import com.mana.spring.service.UserService;
import com.mana.spring.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends OncePerRequestFilter {


    @Autowired
    public UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        if (jwtTokenUtil.checkJWTToken(httpServletRequest)) {
            Claims claims = jwtTokenUtil.getClaimFromToken(httpServletRequest);
            if (claims.get("authorities") != null && !jwtTokenUtil.isTokenExpired(claims)) {
                setUpSpringAuthentication(claims);
            } else {
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    /**
     * After setting the Authentication in the context, we specify
     * that the current user is authenticated. So it passes the
     * Spring Security Configurations successfully.
     **/
    private void setUpSpringAuthentication(Claims claims) {
        UserDetails userDetails = userService.loadUserByUsername(claims.getSubject());
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public String readAllCookies(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
        }

        return "No cookies";
    }
}
