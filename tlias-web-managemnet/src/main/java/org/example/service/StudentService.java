package org.example.service;

import org.example.pojo.PageResult;
import org.example.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 学员列表条件分页查询
     */
    PageResult<Student> page(Integer page, Integer pageSize, String name, Integer degree, Integer clazzId);

    /**
     * 根据ID查询学员
     */
    Student getInfo(Integer id);

    /**
     * 新增学员
     */
    void save(Student student);

    /**
     * 修改学员
     */
    void update(Student student);

    /**
     * 根据ID批量删除学员
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 违纪处理
     */
    void handleViolation(Integer id, Integer score);
}
