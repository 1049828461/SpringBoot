package cn.grace.service.impl;

import cn.grace.dto.StudentDTO;
import cn.grace.mapper.StudentMapper;
import cn.grace.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getAllStudent() {
        List<StudentDTO> studentList = studentMapper.getAllStudent();
        return studentList;
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        StudentDTO studentDTO = studentMapper.getStudentById(id);
        return studentDTO;
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        studentMapper.addStudent(studentDTO);
    }
}
