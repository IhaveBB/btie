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
import java.util.List;

/**
* @description:
* @param:
* @return:
* @author: IhaveBB
* @date: 2024/11/5
**/
public class PetServlet extends HttpServlet {

    private final PetDAO petDAO = new PetDAO();
    FBK fbk = new FBK();
    ArrayList<Pet> arrayList = new ArrayList<Pet>();
    ArrayList<PetOwner> arrayListPO = new ArrayList<PetOwner>();

    Method method = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String purpose = req.getParameter("purpose");
        try {
            getClass().getMethod(purpose, HttpServletRequest.class, HttpServletResponse.class)
                    .invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            fbk.setFeedBack("请求处理失败，请重试", req);
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    // 查询宠物信息
    public void petow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String petName = req.getParameter("petname");
        String ownerName = req.getParameter("ownername");
        List<Pet> pets = petDAO.searchPets(petName, ownerName);
        req.setAttribute("petList", pets);
        fbk.setFeedBack("宠物信息查询成功", req);
        req.getRequestDispatcher("petsearch_name.jsp").forward(req, resp);
    }

    // 查看宠物详情
    public void see(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String petName = req.getParameter("petname");
        List<Pet> petDetails = petDAO.getPetDetails(petName);
        req.setAttribute("petMess", petDetails);
        req.getRequestDispatcher("petview_name.jsp").forward(req, resp);
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

    // 插入新宠物
    public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String petName = req.getParameter("petname");
        String type = req.getParameter("typeSt");
        String birthDate = req.getParameter("birthdate");
        String ownerName = req.getParameter("ownerSt");

        if (petName.isEmpty() || type.isEmpty() || birthDate.isEmpty() || ownerName.isEmpty()) {
            fbk.setFeedBack("所插入的信息均不能为空", req);
            req.getRequestDispatcher("newpet.jsp").forward(req, resp);
        } else {
            Pet pet = new Pet();
            pet.setName(petName);
            pet.setType(type);
            pet.setBirthDate(birthDate);
            pet.setOwnerName(ownerName);
            petDAO.addPet(pet);
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
