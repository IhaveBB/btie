package com.nicebao;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HBaseUtils {
	//定义变量
	HBaseAdmin admin=null;
	//加载配置文件的对象
	Configuration configuration=null;
	//初始化hbase对象
	private  HBaseUtils(){
		configuration=new Configuration();
		configuration.set("hbase.zookeeper.quorum", "192.168.58.11:2181");
		configuration.set("hbase.rootdir", "hdfs://192.168.58.11:9000/hbase");
		try {
			admin=new HBaseAdmin(configuration);
		}catch (IOException io){
			io.printStackTrace();
		}

	}
	//单利模式
	private  static  HBaseUtils instance=null;
	//实例化 HBaseUtils
	public  static  synchronized  HBaseUtils getInstance(){
		if(null ==instance){
			instance=new HBaseUtils();
		}
		return  instance;
	}


	//插入数据库的方法 插入时要用htable 对象

	//先创建htable
	public  HTable  getHtable(String  tableName){
		HTable table=null;
		try {
			table=new HTable(configuration,tableName);
		}catch (IOException o){
			o.printStackTrace();
		}

		return  table;
	}

	//真正插入数据库的方法

	public  void put(String tableName,String rowKey,String cf,String colum,String value){
		//获取table
		HTable  table=getHtable(tableName);

		//获取put对象
		Put put =new  Put(Bytes.toBytes(rowKey));
		put.add(Bytes.toBytes(cf),Bytes.toBytes(colum),Bytes.toBytes(value));
		try {
			table.put(put);
		}catch (IOException o){
			o.printStackTrace();
		}

	}


	//测试

	public static void main(String[] args) {
		//String tableName = "category";
		String tableName = "category_clickcount";
		////20171122_1  时间和类别
		String rowkey="20171122_1";
		String cf = "info";
		String colum = "cagegory_click_count";
		String value = "100";

		HBaseUtils.getInstance().put(tableName,rowkey,cf,colum,value);
	}
}
