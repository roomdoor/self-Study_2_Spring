package com.example.chapter0605.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 들어가기 전 전처리

        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request); // ContentCaching~~~Wrapper 한번 br 되고나서 커서가 맨 끝으로 가면 다시 읽을 수 없어서 이거 사용
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);


        chain.doFilter(httpServletRequest, httpServletResponse);

        //위에 response 동작하고 나면 후처리

        String url = httpServletRequest.getRequestURI();

        //req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}", url, reqContent);


        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();
        log.info("response status: {}, response body : {}", httpStatus, resContent);

        httpServletResponse.copyBodyToResponse();
    }
}
