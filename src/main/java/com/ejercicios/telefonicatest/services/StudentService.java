package com.ejercicios.telefonicatest.services;

import com.ejercicios.telefonicatest.model.Student;
import com.ejercicios.telefonicatest.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> listStudent() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student saveStudent(Student dto) {
        return repository.save(dto);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
