package com.Utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import  java.io.IOException;
import  java.util.HashMap;
import  java.util.Map;

/** * HBase 操作工具类 */

public class HBaseUtils {
     HBaseAdmin admin = null;
     Configuration configration = null;

    /** * 私有构造方法
     */

    private HBaseUtils(){

        configration = new Configuration();
        configration.set("hbase.zookeeper.quorum", "192.168.58.11:2181");
        configration.set("hbase.rootdir", "hdfs://192.168.58.11:9000/hbase");
        try {
            admin = new HBaseAdmin(configration); } catch (IOException e) {

            e.printStackTrace();
        }
    }
    private static HBaseUtils instance = null;

    /**
     *获取单实例对象
     *@return
     */
    public static synchronized HBaseUtils getInstance(){
        if(null == instance){
        instance = new HBaseUtils();
    }
        return instance;
    }

    /**

     *根据表明获取到 Htable 实例

     *@param tableName

     *@return

     */

    public HTable getTable(String tableName){
        HTable table = null;
        try {
            table = new HTable(configration,tableName); } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
    /**

     *添加一条记录到 Hbase 表 

     *

     *@param tableName Hbase 表名

     * @param rowkey   Hbase 表的 rowkey

     * @param cf   Hbase 表的 columnfamily

     * @param column   Hbase 表的列

     * @param value    写入 Hbase 表的值

     */
    public void put(String tableName,String rowkey,String cf,String column,String value){
        HTable table = getTable(tableName);
        Put put = new Put(Bytes.toBytes(rowkey));
        put.add(Bytes.toBytes(cf),Bytes.toBytes(column),Bytes.toBytes(value));
        try {
            table.put(put);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    /** * 根据表名输入条件获取 Hbase 的记录数
     */
    public Map<String, Long> query(String tableName, String condition) throws IOException {
        Map<String, Long> map = new HashMap<>();
        HTable table = getTable(tableName);
        String cf = "info";
        String qualifier = "click_count";
        Scan scan = new Scan();
        Filter filter = new PrefixFilter(Bytes.toBytes(condition));
        scan.setFilter(filter);
        ResultScanner rs = table.getScanner(scan);
        for (Result result : rs) {
            String row = Bytes.toString(result.getRow());

             Long  clickCount = Bytes.toLong(result.getValue(cf.getBytes(), qualifier.getBytes()));

            map.put(row, clickCount);
        }
        return map;
    }
    public static void main(String[] args) throws IOException {
        Map<String, Long> map = HBaseUtils.getInstance().query("category_clickcount", "20240711");
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }

    }

}
