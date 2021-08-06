package com.temzu.preparation.lesson_7.services;

import com.temzu.preparation.lesson_7.model.dtos.StudentDto;
import com.temzu.preparation.lesson_7.model.entities.Student;
import com.temzu.preparation.lesson_7.model.mappers.StudentMapper;
import com.temzu.preparation.lesson_7.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    @Override
    public Page<StudentDto> getAllStudents(int page, int size) {
        return studentRepository.findAll(PageRequest.of(page, size)).map(mapper::toStudentDto);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return mapper.toStudentDto(studentRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto saveOrUpdate(StudentDto studentDto) {
        Student student = mapper.toStudentEntity(studentDto);
        return mapper.toStudentDto(studentRepository.save(student));
    }
}
