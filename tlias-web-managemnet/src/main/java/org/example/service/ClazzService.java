package org.example.service;

import org.example.pojo.Clazz;
import org.example.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {

    /**
     * 班级列表条件分页查询
     */
    PageResult<Clazz> page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end);

    /**
     * 根据ID删除班级（班级下有学员时不允许删除）
     */
    void delete(Integer id);

    /**
     * 新增班级
     */
    void save(Clazz clazz);

    /**
     * 修改班级
     */
    void update(Clazz clazz);

    /**
     * 根据ID查询班级
     */
    Clazz getInfo(Integer id);

    /**
     * 查询所有班级（用于学员管理中的班级下拉列表）
     */
    List<Clazz> listAll();
}
