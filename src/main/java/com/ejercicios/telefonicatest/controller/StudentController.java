package com.ejercicios.telefonicatest.controller;

import com.ejercicios.telefonicatest.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public interface StudentController {

    @GetMapping("/{id}")
    ResponseEntity<Student> getStudent(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    List<Student> list();

    @PostMapping("/")
    Student studentAdd(@RequestBody Student student);

    @PutMapping("/{id}")
    ResponseEntity<Student> studentUpdate(@PathVariable Long id, @RequestBody Student student);

    @DeleteMapping("/{id}")
    ResponseEntity<Object> studentDelete(@PathVariable Long id);
}
