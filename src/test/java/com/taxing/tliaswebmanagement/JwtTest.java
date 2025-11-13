package com.taxing.tliaswebmanagement;

import ch.qos.logback.core.net.server.Client;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGenerateJwt(){
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","admin");
        String jwt= Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"dGF4aW5n")
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))//设置过期时间
                .compact();//生成令牌
        System.out.println(jwt);
    }
    @Test
    public void testParseJWT(){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc1NzMwNTgzMn0.GdrmL7TkpwW4mV-ahD1uzkrgEoymKzC4ZK50nSqT-pU";
        Claims claims= Jwts.parser()
                .setSigningKey("dGF4aW5n")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
