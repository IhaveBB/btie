package com;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class CategoryClickCountDAO {

    public  List <CategoryClickCount>query(String day) throws IOException {
        List<CategoryClickCount> list=new ArrayList<>();
        Map<String,Long> map=HBaseUtils.getInstance().query("category_clickcount",day);
        for(Map.Entry<String,Long>entry:map.entrySet()){
            CategoryClickCount categoryClickCount=new CategoryClickCount();
            categoryClickCount.setName(entry.getKey());
            categoryClickCount.setValue(entry.getValue());
            list.add(categoryClickCount); }
           return list;
    }
//    public static void main(String[]args)throws IOException{
//        CategoryClickCountDAO dao=new CategoryClickCountDAO();
//        List<CategoryClickCount>list=dao.query("20240711");
//        for(CategoryClickCount c:list){
//            System.out.println(c.getValue());
//        }
//    }
}