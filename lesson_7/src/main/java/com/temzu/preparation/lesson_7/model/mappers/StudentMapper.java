package com.temzu.preparation.lesson_7.model.mappers;

import com.temzu.preparation.lesson_7.model.dtos.StudentDto;
import com.temzu.preparation.lesson_7.model.entities.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private ModelMapper mapper;

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public StudentDto toStudentDto(Student student) {
        return mapper.map(student, StudentDto.class);
    }

    public Student toStudentEntity(StudentDto studentDto) {
        return mapper.map(studentDto, Student.class);
    }
}
