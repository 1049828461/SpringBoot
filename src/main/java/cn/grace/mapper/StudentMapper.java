package cn.grace.mapper;

import cn.grace.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author Grace
 */
public interface StudentMapper {
    List<StudentDTO> getAllStudent();

    StudentDTO getStudentById(Integer id);

    void addStudent(StudentDTO studentDTO);

}
