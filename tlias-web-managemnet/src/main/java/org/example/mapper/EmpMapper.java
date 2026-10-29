package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    /**
     * 条件查询员工列表（供分页插件使用）
     */
    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 查询全部员工
     */
    List<Emp> listAll();

    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    Emp getById(Integer id);

    void updateById(Emp emp);

    void deleteByIds(@Param("ids") List<Integer> ids);

    List<Map<String, Object>> countEmpJobData();

    List<Map> countEmpGenderData();

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);
}
