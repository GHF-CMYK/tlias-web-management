package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Student;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /**
     * 条件查询学员列表（供分页插件使用）
     */
    List<Student> list(@Param("name") String name,
                       @Param("degree") Integer degree,
                       @Param("clazzId") Integer clazzId);

    /**
     * 根据ID查询学员
     */
    Student getById(Integer id);

    /**
     * 新增学员
     */
    void insert(Student student);

    /**
     * 修改学员
     */
    void update(Student student);

    /**
     * 根据ID批量删除学员
     */
    void deleteByIds(@Param("ids") List<Integer> ids);

    /**
     * 违纪处理：违纪次数 +1，违纪扣分 + score
     */
    void updateViolation(@Param("id") Integer id, @Param("score") Integer score);

    /**
     * 统计学员学历信息
     */
    List<Map> countStudentDegreeData();

    /**
     * 统计每个班级的学员人数
     */
    List<Map<String, Object>> countStudentCountData();
}
