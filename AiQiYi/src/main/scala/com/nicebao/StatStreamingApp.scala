package com.nicebao;

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

import scala.collection.mutable.ListBuffer
object StatStreamingApp {
  def main(args: Array[String]): Unit = {
    //streaming对象
    var  ssc= new StreamingContext("local[*]","StatStreamingApp",Seconds(5))
    //

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "192.168.58.11:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "test",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )
    //要读取的kafak的top
    val  topics=Array("flumeTopic")
    val logs=KafkaUtils.createDirectStream[String,String](
      ssc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    ).map(_.value())
    //logs.print()
    //使用spark  做数据分析
    //167.132.29.100  2019-11-03 17:32:33     "GET /www/1 HTTP/1.1"   https://www.sogou.com/web?qu=奇葩说     404

    val  cleanData= logs.map(line=>{
      //读取一行按空格切割
      val  infos = line.split("\t")
      //取出类别 /www/1
      val  url= infos(2).split(" ")(1)
      var categaryId=0
      if(url.startsWith("/www")){
        categaryId=url.split("/")(2).toInt
        print("..............类别为    ......",categaryId)

      }
      //把数据放到clicklog对象中
      ClickLog(infos(0),DataUtils.parseToMin(infos(1)),categaryId,infos(3),infos(4).toInt)
    }).filter(clickLog=>clickLog.categaryId!=0)

    //cleanData.print()
    //保存数据到数据库中  如果这个时间的这个类别第一次访问就是一次
    cleanData.map(log=>{
      (log.time.substring(0,8)+"_"+log.categaryId,1)
    }).reduceByKey(_+_).foreachRDD(rdd=>{
      rdd.foreachPartition(partitionadd=>{
        val list=new ListBuffer[CategaryClickCount]
        partitionadd.foreach(part=>{
          list.append(CategaryClickCount(part._1,part._2))
        })
        CategaryClickCountDAO.save(list)
      })
    })




    ssc.start()
    // 关闭，并允许关闭声明后新任务能提交
    ssc.awaitTermination()
  }
}