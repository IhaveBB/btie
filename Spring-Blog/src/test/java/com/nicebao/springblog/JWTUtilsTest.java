package com.nicebao.springblog;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtilsTest {
	private final static long EXPIRATION_DATE = 60 * 60 * 1000;
	private final static String secretString = "lWcsGLXDhFQ+MQqMbZcvSmVUrk//bZd4peO8g4+wv98=";
	private final static Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
	@Test
	public void getToken(){
		Map<String,Object> claim = new HashMap<>();
		claim.put("id",5);
		claim.put("name","zhangsan");
		String token = Jwts.builder()
				.signWith(key)
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_DATE))
				.setClaims(claim)
				.compact();
		System.out.println(token);
	}
@Test
	public void getKey(){
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String encode =  Encoders.BASE64.encode(secretKey.getEncoded());
		System.out.println(encode);
	}
	@Test
	public void rarseToken(){
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJpZCI6NX0.0XrY41FNI-P-nCTNGdwyPStIiqqevMHsvRG04TWM0bk";
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		Claims body = null;
		try {
			body = jwtParser.parseClaimsJws(token).getBody();
		}catch (Exception e){
			System.out.println("令牌校验失败:"+e.getMessage());
		}
		System.out.println(body);
	}

}
