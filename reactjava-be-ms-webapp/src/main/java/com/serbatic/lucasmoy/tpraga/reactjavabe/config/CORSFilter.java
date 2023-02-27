package com.serbatic.lucasmoy.tpraga.reactjavabe.config;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CORSFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
        response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
        if ("OPTIONS".equals(request.getMethod())) {
            System.out.println("enters in if");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            System.out.println("enters in else");
            filterChain.doFilter(request, response);
        }
    }
}