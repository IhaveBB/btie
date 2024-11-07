package com.nicebao.servlet;


import com.nicebao.Bean.PetOwner;
import com.nicebao.Dao.OwnerDAO;
import com.nicebao.util.FBK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class PetOwnerServlet extends HttpServlet {

    ArrayList<PetOwner> arrayList;
    FBK fbk = new FBK();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String purpose = req.getParameter("purpose");
        if (purpose.equals("see")){
            OwnerDAO od = new OwnerDAO();
            arrayList =  od.viewOwner(req.getParameter("ownername"));
            req.setAttribute("ownerList",arrayList);
            req.getRequestDispatcher("ownerupdate.jsp").forward(req,resp);

        }else if (purpose.equals("upda")){
            req.setCharacterEncoding("UTF-8");
            String ownerid = req.getParameter("ownerid");
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String city = req.getParameter("city");
            String telephone = req.getParameter("telephone");

            if (ownerid.isEmpty() || name.isEmpty() || address.isEmpty() || city.isEmpty() || telephone.isEmpty()){
                OwnerDAO od = new OwnerDAO();
                arrayList =  od.viewOwner(req.getParameter("ownername"));
                req.setAttribute("ownerList",arrayList);
                fbk.setFeedBack("所有人信息均不能为空", req);

            }else {
                OwnerDAO od = new OwnerDAO();
                PetOwner po = new PetOwner();
                po.setId(Integer.parseInt(req.getParameter("ownerid")));
                po.setName(req.getParameter("name"));
                po.setAddress(req.getParameter("address"));
                po.setCity(req.getParameter("city"));
                po.setTelephone(req.getParameter("telephone"));
                od.updateOwner(po);
                arrayList = new ArrayList<PetOwner>();
                arrayList.add(po);
                req.setAttribute("newMess", arrayList);

                fbk.setFeedBack("所有人信息修改成功", req);
            }

            req.getRequestDispatcher("ownerupdate.jsp").forward(req,resp);

        }else if (purpose.equals("addperson")){
            req.getRequestDispatcher("newowner.jsp").forward(req,resp);

        }else if (purpose.equals("insert")){
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String city = req.getParameter("city");
            String telephone = req.getParameter("telephone");

            if (name.isEmpty() || address.isEmpty() || city.isEmpty() || telephone.isEmpty()){
                fbk.setFeedBack("所插入的信息均不为空", req);

                req.getRequestDispatcher("newowner.jsp").forward(req, resp);
            }else {
                PetOwner po = new PetOwner();
                po.setName(name);
                po.setAddress(address);
                po.setCity(city);
                po.setTelephone(telephone);
                OwnerDAO od = new OwnerDAO();
                od.addPerson(po);

                fbk.setFeedBack("所有人信息插入成功", req);

                req.getRequestDispatcher("petsearch.jsp").forward(req, resp);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
