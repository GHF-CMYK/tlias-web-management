package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Clazz;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {

    /**
     * 条件查询班级列表（供分页插件使用）
     */
    List<Clazz> list(@Param("name") String name,
                     @Param("begin") LocalDate begin,
                     @Param("end") LocalDate end);

    /**
     * 查询所有班级
     */
    List<Clazz> listAll();

    /**
     * 根据ID删除班级
     */
    void deleteBy(Integer id);

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
    Clazz getBy(Integer id);

    /**
     * 统计班级下的学员数量
     */
    Long countStudentByClazzId(Integer id);
}
