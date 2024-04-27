package com.nicebao.springblog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
/**
 * 简单日期格式
 *
 * @name: DateUtils
 * @author: IhaveBB
 * @date: 2024-04-17 22:06
 **/
	public static String formatDate(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(date == null){
			return null;
		}
		return simpleDateFormat.format(date);
	}

}
