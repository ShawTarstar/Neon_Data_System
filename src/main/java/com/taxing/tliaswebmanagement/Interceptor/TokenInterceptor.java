package com.taxing.tliaswebmanagement.Interceptor;

import com.taxing.tliaswebmanagement.utils.CurrentHolder;
import com.taxing.tliaswebmanagement.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestURI = request.getRequestURI();
//        if(requestURI.contains("/login")){
//            log.info("登录请求，放行");
//            return true;
//        }
        String token = request.getHeader("token");
        if(token==null||token.isEmpty()){
            log.info("令牌为空，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        try{
            Claims claims= JwtUtils.parseToken(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("当前用户id为：{}，将其存入ThreadLocal",empId);
        }catch (Exception e){
            log.info("令牌非法，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        log.info("令牌合法，放行");
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("请求处理完毕，清空ThreadLocal");
        CurrentHolder.remove();
    }
}
