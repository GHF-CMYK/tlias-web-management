package org.example.service.impl;

import org.example.mapper.EmpMapper;
import org.example.mapper.StudentMapper;
import org.example.pojo.ClazzOption;
import org.example.pojo.JobOption;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 数据统计业务实现
 */
@Service
public class ReportServiceImpl implements ReportService {

    /** 员工信息 Mapper */
    @Autowired
    private EmpMapper empMapper;

    /** 学员信息 Mapper */
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    /**
     * 统计学员学历信息
     */
    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    /**
     * 统计每个班级的学员人数
     */
    @Override
    public ClazzOption getStudentCountData() {
        //1. 查询每个班级的学员人数
        List<Map<String,Object>> list = studentMapper.countStudentCountData();
        //2. 拆分为班级名称列表和数据列表，供前端 ECharts 使用
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new ClazzOption(clazzList, dataList);
    }
}
