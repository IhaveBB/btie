package com.nicebao.util;



import com.nicebao.Bean.FeedBack;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/6
**/
public class FBK {

    public void setFeedBack(String mess, HttpServletRequest req){
        ArrayList<FeedBack> arrayListFb = new ArrayList<FeedBack>();
        FeedBack fb = new FeedBack();
        fb.setMess(mess);
        arrayListFb.add(fb);
        req.setAttribute("listFb",arrayListFb);
    }

}
