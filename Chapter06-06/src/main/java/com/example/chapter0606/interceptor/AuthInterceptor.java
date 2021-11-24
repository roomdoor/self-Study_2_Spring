package com.example.chapter0606.interceptor;

import com.example.chapter0606.annotation.Auth;
import com.example.chapter0606.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build().toUri();

        log.info("request url : {}", url);
        boolean hasAnnotation = checkedAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        // 나의 서버는 모두 public 으로 동작하는데
        // 단 Auth  권한을 가진 요청에 대해서는 세션, 쿠키 등을 보는 뭔가를 하는 정책을 추가하겠다

        if (hasAnnotation) {
            // 권한 체크
            String query = uri.getQuery();
            log.info("query : {}", query);

            if (query.equals("name=aaa")) {
                return true;
            }

            throw new AuthException("aaa 가 아님");
        }

        return true;        // true 가 되어야 interceptor 넘어서 handler 로 갈 수 있음 ( 그림 강의 참고 )
    }

    private boolean checkedAnnotation(Object handler, Class clazz) {

        // response = javascrit, html 인 경우에는 무조껀 통과 시켜 줘야함
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            // Auth annotation 이 있는 경우 true 반환
            return true;
        }

        return false;


    }
}
