package com.nicebao.springblog.utils;

import com.nicebao.springblog.constants.Constant;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Slf4j
public class JWTUtils {
	private final static long EXPIRATION_DATE = 60 * 60 * 1000;
	private final static String secretString = "lWcsGLXDhFQ+MQqMbZcvSmVUrk//bZd4peO8g4+wv98=";
	private final static Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
	public static String getToken(Map<String,Object> claim){
		String token = Jwts.builder()
				.signWith(key)
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_DATE))
				.setClaims(claim)
				.compact();
		return token;
	}
	public  String getKey(){
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String encode =  Encoders.BASE64.encode(secretKey.getEncoded());
		return encode;
	}

	public static Claims parseToken(String token){
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		Claims body = null;
		try {
			body = jwtParser.parseClaimsJws(token).getBody();
		} catch (ExpiredJwtException e) {
			log.error("token过期 校验失败,token:"+token);
		} catch (Exception e) {
			log.error("token校验失败,token:"+token);
		}
		return body;
	}

	public static boolean checkToken(String token){
		Claims body = parseToken(token);
		if(body == null){
			return false;
		}
		return true;
	}

	public static Integer getUserIdFromToken(String token){
		Claims body = parseToken(token);
		if(body != null){
			return (Integer) body.get(Constant.USER_CLAIM_ID) ;
		}
		return -1;
	}
}
