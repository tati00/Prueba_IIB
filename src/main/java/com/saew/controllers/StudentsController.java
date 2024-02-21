package com.saew.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saew.dto.Student;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private List<Student> students;

    public List<Student> agregarEstudiantes() {
        students.add(new Student(1, "Erika", "erika@epn.edu.ec", 9.55f));
        students.add(new Student(1, "Luis", "luis@epn.edu.ec", 9.85f));
        students.add(new Student(1, "Jeremy", "jeremy@epn.edu.ec", 5.5f));
        students.add(new Student(1, "Aislyn", "aislyn@epn.edu.ec", 6.83f));
        return students;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/getStudentByName/{name}")
    public List<Student> getStudentByName(@RequestParam String name) {
        return students.stream().filter(student -> student.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> optStudents = students.stream().filter(student -> student.getId().equals(id)).findFirst();
        if (optStudents.isPresent()) {
            return ResponseEntity.ok(optStudents.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(Student student) {
        students.add(student);
        return ResponseEntity.ok(student);
    }

    @PatchMapping
    public ResponseEntity<Student> updateProduct(Student product) {
        students.add(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(String id) {
        students.remove(id);
        return ResponseEntity.ok(students.remove(id));
    }

}
