package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量新增员工工作经历
     */
    void insertBatch(@Param("exprList") List<EmpExpr> exprList);

    /**
     * 根据员工ID批量删除工作经历
     */
    void deleteByEmpIds(@Param("ids") List<Integer> ids);
}
