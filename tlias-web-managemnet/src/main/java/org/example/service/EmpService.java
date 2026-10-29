package org.example.service;

import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;
import org.example.pojo.LoginInfo;
import org.example.pojo.PageResult;

import java.util.List;

public interface EmpService {

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
    /**
     * 查询全部员工
     */
    List<Emp> listAll();
    /**
     * 添加员工
     */
    void save(Emp emp);

    Emp getInfo(Integer id);

    void update(Emp emp);

    void deleteByIds(List<Integer> ids);
    /**
     * 登录
     */
    LoginInfo login(Emp emp);
}
