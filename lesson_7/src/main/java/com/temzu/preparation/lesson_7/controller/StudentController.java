package com.temzu.preparation.lesson_7.controller;

import com.temzu.preparation.lesson_7.model.dtos.StudentDto;
import com.temzu.preparation.lesson_7.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping
    public Page<StudentDto> getAllStudents(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "s", defaultValue = "10") Integer pageSize
    ) {
        if (page < 1 || pageSize < 1) {
            page = 1;
            pageSize = 10;
        }
        return studentService.getAllStudents(page, pageSize);
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto saveStudent(@RequestBody StudentDto studentDto) {
        studentDto.setId(null);
        return studentService.saveOrUpdate(studentDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveOrUpdate(studentDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

}
