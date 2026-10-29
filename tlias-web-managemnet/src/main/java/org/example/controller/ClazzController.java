package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Clazz;
import org.example.pojo.Result;
import org.example.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * 班级管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 班级列表条件分页查询
     * GET /clazzs?name=java&begin=2023-01-01&end=2023-06-30&page=1&pageSize=5
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("查询请求参数： page={}, pageSize={}, name={}, begin={}, end={}", page, pageSize, name, begin, end);
        return Result.success(clazzService.page(page, pageSize, name, begin, end));
    }

    /**
     * 查询所有班级
     * GET /clazzs/list
     */
    @GetMapping("/list")
    public Result listAll() {
        log.info("查询所有班级");
        return Result.success(clazzService.listAll());
    }

    /**
     * 根据ID查询班级
     * GET /clazzs/{id}
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询班级: {}", id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    /**
     * 添加班级
     * POST /clazzs
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("请求数据Clazz: {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 修改班级
     * PUT /clazzs
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级: {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 根据班级ID删除
     * DELETE /clazzs/{id}
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据班级ID删除: {}", id);
        clazzService.delete(id);
        return Result.success();
    }
}
