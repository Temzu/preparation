package com.temzu.preparation.lesson_7.services;

import com.temzu.preparation.lesson_7.model.dtos.StudentDto;
import com.temzu.preparation.lesson_7.model.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IStudentService {

    Page<StudentDto> getAllStudents(int page, int size);

    StudentDto getStudentById(Long id);

    void deleteStudentById(Long id);

    StudentDto saveOrUpdate(StudentDto studentDto);
}
