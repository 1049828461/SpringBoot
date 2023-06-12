package cn.grace.controller;

import cn.grace.dto.StudentDTO;
import cn.grace.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * 测试使用 @RequestMapping 注解
     * 查询所有学生信息
     * @return
     */
    @RequestMapping("/getAllStudent")
    public List<StudentDTO> getAllStudent(){
        List<StudentDTO> studentList = studentService.getAllStudent();
        return studentList;
    }

    /**
     * 测试使用 @GetMapping 注解 + restful 风格
     * 查询单个学生信息并直接返回（并且使用 @Cacheable 缓存了查询结果）
     * 请求url示例：http://localhost:8080/student/getStudent/1
     * @param id
     * @return
     */
    @GetMapping ("/getStudent/{id}")
    @Cacheable("student")
    public StudentDTO getStudent(@PathVariable(name="id") Integer id){
        StudentDTO studentDTO = studentService.getStudentById(id);
        return studentDTO;
    }

    /**
     * 测试使用 @GetMapping 注解 + restful 风格
     * 查询单个学生信息并直接返回（并且使用 @Cacheable 缓存了查询结果）
     * 使用了自定义的缓存管理器: cacheManager（Object类型数据不会乱码）
     * 请求url示例：http://localhost:8080/student/getStudentByMyRedisCacheManager/1
     * @param id
     * @return
     */
    @GetMapping ("/getStudentByMyRedisCacheManager/{id}")
    @Cacheable(cacheNames = "student",key = "#id",cacheManager = "cacheManager")
    public StudentDTO getStudentByMyRedisCacheManager(@PathVariable(name="id") Integer id) {
        StudentDTO studentDTO = studentService.getStudentById(id);
        return studentDTO;
    }

    /**
     * 测试使用 @PostMapping 注解
     * 新增学生信息
     * @param studentDTO
     * @return
     */
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentDTO studentDTO){
            studentService.addStudent(studentDTO);
            return "success";
    }


}
