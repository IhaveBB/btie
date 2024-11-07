package com.nicebao.servlet;



import com.nicebao.Bean.Pet;
import com.nicebao.Bean.PetOwner;
import com.nicebao.Dao.OwnerDAO;
import com.nicebao.Dao.PetDAO;
import com.nicebao.util.FBK;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class PetServlet extends HttpServlet {

    Pet pet;
    FBK fbk = new FBK();
    ArrayList<Pet> arrayList = new ArrayList<Pet>();
    ArrayList<PetOwner> arrayListPO = new ArrayList<PetOwner>();

    Method method = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String purpose = req.getParameter("purpose");

        Class c = this.getClass();

        try {
            method = c.getMethod(purpose, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void petow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String petname = req.getParameter("petname");
        String ownername = req.getParameter("ownername");
        System.out.println("反射机制");
        if (petname.isEmpty() && ownername.isEmpty()){
            fbk.setFeedBack("请输入正确的索引", req);
            req.getRequestDispatcher("petsearch.jsp").forward(req,resp);

        }else {
            PetDAO pd = new PetDAO();
            arrayList = pd.searchOOP(petname, ownername);
            req.setAttribute("petList", arrayList);

            fbk.setFeedBack("宠物信息查询成功",req);

            req.getRequestDispatcher("petsearch_name.jsp").forward(req, resp);
        }
    }

    public void see(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("see返");
        PetDAO pd = new PetDAO();
        arrayList = pd.petMess(req.getParameter("petname"));
        req.setAttribute("petMess",arrayList);

        req.getRequestDispatcher("petview_name.jsp").forward(req,resp);
    }

    public void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("petViewList",arrayList);

        PetDAO pt = new PetDAO();
        arrayList = pt.getTypeSelect();
        req.setAttribute("typeList",arrayList);

        req.getRequestDispatcher("petupdate.jsp").forward(req,resp);

    }

    public void upda(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        PetDAO pd = new PetDAO();
        Pet pt = new Pet();
        pt.setId(Integer.parseInt(req.getParameter("petid")));
        pt.setName(req.getParameter("name"));
        pt.setBirthDate(req.getParameter("birthdate"));
        pt.setType(req.getParameter("updateType"));
        pt.setOwnerName(req.getParameter("ownername"));
        pd.petUpdate(pt);
        arrayList = pd.petMess(req.getParameter("name"));
        req.setAttribute("newPetMess", arrayList);

        fbk.setFeedBack("宠物信息修改成功",req);

        req.getRequestDispatcher("petview_name.jsp").forward(req,resp);

    }

    public void addpet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OwnerDAO od = new OwnerDAO();
        arrayListPO = od.getOwnerSelect();
        req.setAttribute("ownerSelect",arrayListPO);

        PetDAO pt = new PetDAO();
        arrayList = pt.getTypeSelect();
        req.setAttribute("typeSelect",arrayList);

        req.getRequestDispatcher("newpet.jsp").forward(req,resp);

    }

    public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String petname = req.getParameter("petname");
        String typeSt = req.getParameter("typeSt");
        String birthdate = req.getParameter("birthdate");
        String ownerSt = req.getParameter("ownerSt");

        if (petname.isEmpty() || typeSt.isEmpty() || birthdate.isEmpty() || ownerSt.isEmpty()){
            fbk.setFeedBack("所插入的信息均不能为空", req);

            req.getRequestDispatcher("newpet.jsp").forward(req, resp);

        }else {

            pet = new Pet();
            pet.setName(petname);
            pet.setType(typeSt);
            pet.setBirthDate(birthdate);
            pet.setOwnerName(ownerSt);

            PetDAO pd = new PetDAO();
            pd.addPet(pet);

            fbk.setFeedBack("宠物信息插入成功", req);

            req.getRequestDispatcher("petsearch.jsp").forward(req, resp);
        }

    }

    public void allPet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int pageSize = 5;

        String pageStr = req.getParameter("page");
        if (pageStr != null && !pageStr.isEmpty()) {
            try {
                page = Integer.parseInt(pageStr);
            } catch (NumberFormatException e) {
                page = 1;
            }
        }

        PetDAO pd = new PetDAO();
        ArrayList<Pet> arrayList = pd.allPet(page, pageSize);
        req.setAttribute("petList", arrayList);

        int totalRecords = pd.getTotalPetCount();
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);

        fbk.setFeedBack("所有信息显示成功", req);

        req.getRequestDispatcher("petsearch_name.jsp").forward(req, resp);
    }



    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String petName = req.getParameter("petName");
        String ownerName = req.getParameter("ownerName");

        PetDAO pd = new PetDAO();

        pd.delPet(petName, ownerName);

        fbk.setFeedBack("客户信息删除成功",req);
        req.getRequestDispatcher("petsearch.jsp").forward(req, resp);

    }


}
