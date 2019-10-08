package com.ihrm.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseJwtTest {

    /**
     * 解析jwtToken字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4OCIsInN1YiI6IuWwj-eZvSIsImlhdCI6MTU1MTkzODIxMiwiY29tcGFueUlkIjoiMTIzNDU2IiwiY29tcGFueU5hbWUiOiLmi5PpgqYifQ.hqRXqSA21TEMZk0mjPd9kafPAx88aeyTn3wu_Su1dKs";
        Claims claims = Jwts.parser().setSigningKey("ihrm").parseClaimsJws(token).getBody();

        //私有数据存放在claims
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());

        //解析自定义claim中的内容
        String companyId = (String) claims.get("companyId");
        String companyName = (String) claims.get("companyName");

        System.out.println(companyId + "---" + companyName);
    }
}
