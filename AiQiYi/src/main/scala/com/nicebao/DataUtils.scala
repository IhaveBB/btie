package com.nicebao


import java.util.Date

import org.apache.commons.lang3.time.FastDateFormat

/**
 * 日期格式转换类
 * 10.187.124.132	2024-07-11 15:44:01	"GET /www/6 HTTP/1.1"	https://search.yahoo.com/search?p=极限挑战	404
 */
object DataUtils {
  //获取数据的日期格式
  val YYYYMMDDHHMMSS_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")
  //转换后的日期格式
  val TAG_FORMAT = FastDateFormat.getInstance("yyyyMMdd")
  //获取时间戳
  def  getTime(time:String)={
    YYYYMMDDHHMMSS_FORMAT.parse(time).getTime
  }
  def  parseToMin(time:String)={
    TAG_FORMAT.format(new Date(getTime(time)))
  }


  def main(args: Array[String]): Unit = {
    print(parseToMin("2017-11-20 00:39:26"))
  }

}