package com.nicebao.service;


import com.nicebao.pojo.Page;
import com.nicebao.pojo.Sct;

import java.util.List;

public interface SctService {

    //添加选课信息
    public void addSct(Sct sct);

    //删除选课信息
    public void deleteSct(Integer sct_no);

    //修改选课信息
    public void updateSct(Sct sct);

    //通过ID查询一个选课信息
    public Sct querySctbyId(Integer sct_no);

    public Sct querySctbySno(Integer sno);

    public Sct querySctbyCno(Integer cno);

    public Sct querySctbyTno(Integer tno);

    public List<Sct> queryScts();

    Page<Sct> page(int pageNo, int pageSize);

    Page<Sct> findOneBySno(int pageNo, int pageSize, Integer sno);

    Page<Sct> findOneByCno(int pageNo, int pageSize, Integer cno);


}
