package com.nicebao

/**
 * Created by IhaveBB on 2024/7/11 20:57
 */
import org.apache.hadoop.hbase.client.Get
import org.apache.hadoop.hbase.client.HTable
import org.apache.hadoop.hbase.util.Bytes

import scala.collection.mutable.ListBuffer
//保存访问类别数据的dao

object CategaryClickCountDAO {
  //这个表名和数据库中的要一致
  val tableName= "category_clickcount"
  //hbase中的列名
  val cf = "info"
  //hbase中数量
  val qualifer = "click_count"
  //保存数据的方法
  def  save(list:ListBuffer[CategaryClickCount]): Unit ={
    val  table=HBaseUtils.getInstance().getHtable(tableName)
    for(els <- list){
      table.incrementColumnValue(Bytes.toBytes(els.day_categaryId),Bytes.toBytes(cf),Bytes.toBytes(qualifer),els.click_count)
    }

  }

  //查询的方法
  def  count(day_categary:String): Long ={
    val  table= HBaseUtils.getInstance().getHtable(tableName)
    val  get=   new  Get(Bytes.toBytes(day_categary))
    var  value=table.get(get).getValue(Bytes.toBytes(cf),Bytes.toBytes(qualifer))
    if(value==null){
      0L
    }else{
      Bytes.toLong(value)
    }
  }


  def main(args: Array[String]): Unit = {
    val  list=new ListBuffer[CategaryClickCount]
    list.append(CategaryClickCount("20171122_1",100))
    list.append(CategaryClickCount("20171122_2",200))
    list.append(CategaryClickCount("20171122_3",300))
    save(list)
    print(count("20171122_1")+"-----"+count("20171122_2")+"+++++++++++++"+count("20171122_3"))

  }

}