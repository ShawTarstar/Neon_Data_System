package com.taxing.tliaswebmanagement.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 定义密钥（和测试类一致）
    private static final String SECRET_KEY = "dGF4aW5n";

    // 过期时间：12小时（单位：毫秒）
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;

    /**
     * 生成JWT令牌
     * @param claims 自定义数据（例如用户id、用户名等）
     * @return 生成的JWT字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims) // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 设置过期时间
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param token JWT字符串
     * @return 解析出的Claims对象（包含token内的自定义数据）
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // 设置签名密钥
                .parseClaimsJws(token)
                .getBody();
    }
}
