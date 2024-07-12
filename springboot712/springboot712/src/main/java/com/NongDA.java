package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NongDA {

    private static Map<String,String> courses = new HashMap<>();
    //没表中这个代替
    static {
        //这个和py文件中的一致
        courses.put("1","大片电影");
        courses.put("2","宫斗谋权");
        courses.put("3","记录片等");
        courses.put("4", "动漫动画");
        courses.put("5", "音乐制作");
        courses.put("6", "综艺制作");
        courses.put("130", "历险科幻");

    }
    //查询数据
    @Autowired
    CategoryClickCountDAO categoryClickCountDAO;

    //这个要和Ajax的提交的url的路径一致
    @RequestMapping(value = "/clickcount", method = RequestMethod.POST)
    // @ResponseBody
    public List<CategoryClickCount> courseClickCount() throws Exception {
        //如果main方法测试必须实例化 CategoryClickCountDAO
        //categoryClickCountDAO=new CategoryClickCountDAO();
        List<CategoryClickCount> list = categoryClickCountDAO.query("20240712");
        //把数据和courses对比和爬虫文件中的数据要一致
        //model.getName().substring(9）从9位开始取 取到最后
        for(CategoryClickCount model:list){
            String name= courses.get(model.getName().substring(9));
            if(name!=null){
                model.setName(name);
            }else{
                model.setName("其他");
            }
        }
        return list;
    }
        @RequestMapping("/aqy")
        public ModelAndView  ff1(){
            return  new ModelAndView("ab.html");

        }
}
