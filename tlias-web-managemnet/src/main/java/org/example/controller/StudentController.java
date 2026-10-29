package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学员管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 学员列表条件分页查询
     * GET /students?name=张三&degree=1&clazzId=2&page=1&pageSize=5
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Integer degree, Integer clazzId) {
        log.info("查询请求参数： page={}, pageSize={}, name={}, degree={}, clazzId={}",
                page, pageSize, name, degree, clazzId);
        return Result.success(studentService.page(page, pageSize, name, degree, clazzId));
    }

    /**
     * 根据ID查询学员
     * GET /students/{id}
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询学员: {}", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    /**
     * 新增学员
     * POST /students
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("新增学员: {}", student);
        studentService.save(student);
        return Result.success();
    }

    /**
     * 修改学员
     * PUT /students
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学员: {}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 根据ID批量删除学员
     * DELETE /students/1,2,3
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除学员: ids={}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }

    /**
     * 违纪处理
     * PUT /students/violation/{id}/{score}
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("违纪处理: id={}, score={}", id, score);
        studentService.handleViolation(id, score);
        return Result.success();
    }
}
