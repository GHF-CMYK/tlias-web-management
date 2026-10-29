package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Emp;
import org.example.pojo.EmpQueryParam;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工管理控制器
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 员工列表条件分页查询
     * GET /emps?name=张&gender=1&begin=2007-09-01&end=2022-09-01&page=1&pageSize=10
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("查询请求参数： {}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 查询全部员工
     * GET /emps/list
     */
    @GetMapping("/list")
    public Result listAll() {
        log.info("查询全部员工");
        return Result.success(empService.listAll());
    }

    /**
     * 添加员工
     * POST /emps
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("请求参数emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 批量删除员工
     * DELETE /emps?ids=1,2,3
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除部门: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 查询回显
     * GET /emps/{id}
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据id查询员工的详细信息");
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /**
     * 更新员工信息
     * PUT /emps
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
