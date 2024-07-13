package com.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by IhaveBB on 2024/7/13 8:47
 */
public class DataUtils {
	/**
	 *
	 *
	 * @name: DataUtils
	 * @author: IhaveBB
	 * @date: 2024-07-13 08:47
	 **/

	public static String getCurrentDateFormatted() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return now.format(formatter);
	}
	/**
	 * 获取前一天的日期并格式化
	 *
	 * @return 前一天日期的格式化字符串
	 */
	public static String getPreviousDateFormatted() {
		LocalDate yesterday = LocalDate.now().minus(1, ChronoUnit.DAYS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return yesterday.format(formatter);
	}

	public static void main(String[] args) {
		System.out.println(getCurrentDateFormatted());
		System.out.println(getPreviousDateFormatted());
	}
}
