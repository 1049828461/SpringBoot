package cn.grace.service;

import cn.grace.dto.StudentDTO;
import java.util.List;


public interface StudentService {
    List<StudentDTO> getAllStudent();

    StudentDTO getStudentById(Integer id);

    void addStudent(StudentDTO studentDTO);

}
