package com.ark.jwtstudy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String SING = "Ark_one";

    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SING));
        return token;
    }

    public static void verify(String token) {
        DecodedJWT ark_one = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

    public static DecodedJWT getTokenInfo(String token) {
        DecodedJWT tokenInfo = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        return tokenInfo;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "zhangsan");
        map.put("password", "123456");

//        verify(getToken(map));
        DecodedJWT tokenInfo = getTokenInfo(getToken(map));
        System.out.println(tokenInfo.getExpiresAt());
    }
}
