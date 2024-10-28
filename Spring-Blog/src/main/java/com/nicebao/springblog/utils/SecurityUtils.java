package com.nicebao.springblog.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Slf4j
public class SecurityUtils {
/** @description: 根据明文, 进行加密
		* @param: java.lang.String
		* @return: java.lang.String
		* @author: IhaveBB
		* @date: 2024/5/8
		*/
    public static String encrypt(String password){
        String md5Str = DigestUtils.md5DigestAsHex(password.getBytes());
        String salt = UUID.randomUUID().toString().replace("-","");
        //密文内容: 盐值+明文拼接的字符串进行加密的
        String securityPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
        //salt+密文  存储在数据库中
        return salt+securityPassword;
    }

    /** @description: 密码校验
    		* @param: boolean
    		* @return: boolean
    		* @author: IhaveBB
    		* @date: 2024/5/8
    		*/
    public static boolean verify(String inputPassword, String sqlPassword){
        //sqlPassword  是  salt+ md5(salt+password)
        if (sqlPassword==null || sqlPassword.length()!=64){
            log.error("数据库中的密码格式不对");
            return false;
        }
        String salt = sqlPassword.substring(0,32);
        String secretPassword = DigestUtils.md5DigestAsHex((salt+inputPassword).getBytes());
        return sqlPassword.equals(salt +secretPassword);
    }
}
