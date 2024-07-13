package com.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

	public static void main(String[] args) {
		System.out.println(getCurrentDateFormatted());
	}
}
