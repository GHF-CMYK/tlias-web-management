package org.example.service.impl;

import org.example.exception.BusinessException;
import org.example.mapper.DeptMapper;
import org.example.pojo.Dept;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 部门管理业务实现
 */
@Service
public class DeptServiceImpl implements DeptService {
    /** 部门信息 Mapper */
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        //如果部门下有员工，则不允许删除
        if (deptMapper.countEmpByDeptId(id) > 0) {
            throw new BusinessException("对不起，当前部门下有员工，不能直接删除！");
        }
        deptMapper.deleteById(id);
    }

    @Override
    public void save(Dept dept) {

            //补全基础属性
            dept.setCreateTime(LocalDateTime.now());
            dept.setUpdateTime(LocalDateTime.now());
            //保存部门
            deptMapper.insert(dept);
        }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        //补全基础属性
        dept.setUpdateTime(LocalDateTime.now());
        //保存部门
        deptMapper.update(dept);
    }
}
