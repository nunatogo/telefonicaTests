package com.ejercicios.telefonicatest.controller;

import com.ejercicios.telefonicatest.model.Student;
import com.ejercicios.telefonicatest.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentService service;

    @Override
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        try {
            return service.getStudentById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            log.error("El identificador no es correcto: " + e.getMessage());

            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<Student> list() {
        return service.listStudent();
    }

    @Override
    public Student studentAdd(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @Override
    public ResponseEntity<Student> studentUpdate(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> dto = service.getStudentById(id);

        if (dto.isEmpty()) {
            log.error("El estudiante no existe con identificador: " + id);

            return new ResponseEntity("El identificador del estudiante no existe", HttpStatus.NO_CONTENT);
        } else {
            return service.getStudentById(id)
                    .map(existingStudent -> {
                        existingStudent.setName(student.getName());
                        existingStudent.setSpecialty(student.getSpecialty());
                        existingStudent.setDegree(student.getDegree());
                        Student updatedDTO = service.saveStudent(existingStudent);
                        return ResponseEntity.ok(updatedDTO);
                    })
                    .orElse(ResponseEntity.notFound().build());
        }
    }

    @Override
    public ResponseEntity<Object> studentDelete(@PathVariable Long id) {
        Optional<Student> dto = service.getStudentById(id);

        if (dto.isEmpty()) {
            log.error("El estudiante no existe con identificador: " + id);

            return new ResponseEntity("El identificador del estudiante no existe", HttpStatus.NO_CONTENT);
        } else {
            return dto.map(estudiante -> {
                        service.deleteStudent(id);
                        return ResponseEntity.ok().build();
                    })
                    .orElse(ResponseEntity.notFound().build());
        }
    }
}
