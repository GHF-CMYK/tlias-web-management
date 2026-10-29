package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.StudentMapper;
import org.example.pojo.PageResult;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 学员管理业务实现
 */
@Service
public class StudentServiceImpl implements StudentService {

    /** 学员信息 Mapper */
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 学员条件分页查询
     */
    @Override
    public PageResult<Student> page(Integer page, Integer pageSize, String name, Integer degree, Integer clazzId) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(page, pageSize);
        //2. 执行查询
        List<Student> studentList = studentMapper.list(name, degree, clazzId);
        //3. 封装分页结果
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 根据ID查询学员
     */
    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    /**
     * 新增学员
     */
    @Override
    public void save(Student student) {
        //1. 补全创建时间、修改时间
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        //2. 违纪次数、违纪扣分初始为0
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        //3. 保存学员信息
        studentMapper.insert(student);
    }

    /**
     * 修改学员
     */
    @Override
    public void update(Student student) {
        //每次修改都需要更新修改时间
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    /**
     * 根据ID批量删除学员
     */
    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    /**
     * 违纪处理：违纪次数 +1，违纪扣分累加
     */
    @Override
    public void handleViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }
}
