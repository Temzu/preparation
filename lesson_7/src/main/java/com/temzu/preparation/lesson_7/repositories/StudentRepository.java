package com.temzu.preparation.lesson_7.repositories;

import com.temzu.preparation.lesson_7.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
