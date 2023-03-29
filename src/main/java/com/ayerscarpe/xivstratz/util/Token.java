package com.ayerscarpe.xivstratz.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class Token {
    //7天过期
    private static final long expire = 604800;
    //32位密钥
    private static final String key = "NyLYxq2F4q4aUpMtIg4Ef1nd5XGgdLxN";
    //生成Token
    public static String generateToken(String username){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();
    }
    //解析Token
    public static Claims getClaimsByToken(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }
}
