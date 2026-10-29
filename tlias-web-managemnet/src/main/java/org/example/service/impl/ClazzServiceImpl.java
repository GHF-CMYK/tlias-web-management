package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.exception.BusinessException;
import org.example.mapper.ClazzMapper;
import org.example.pojo.Clazz;
import org.example.pojo.PageResult;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 班级管理业务实现
 */
@Service
public class ClazzServiceImpl implements ClazzService {
    /** 班级信息 Mapper */
    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 班级条件分页查询
     */
    @Override
    public PageResult<Clazz> page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(page, pageSize);
        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(name, begin, end);
        //3. 封装分页结果
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 根据ID删除班级
     */
    @Override
    public void delete(Integer id) {
        //如果班级下关联了学生，则不允许删除
        if (clazzMapper.countStudentByClazzId(id) > 0) {
            throw new BusinessException("对不起, 该班级下有学生, 不能直接删除");
        }
        clazzMapper.deleteBy(id);
    }

    /**
     * 新增班级
     */
    @Override
    public void save(Clazz clazz) {
        //补全创建时间、修改时间
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    /**
     * 修改班级
     */
    @Override
    public void update(Clazz clazz) {
        //每次修改都需要更新修改时间
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    /**
     * 根据ID查询班级
     */
    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getBy(id);
    }

    /**
     * 查询所有班级
     */
    @Override
    public List<Clazz> listAll() {
        return clazzMapper.listAll();
    }
}
