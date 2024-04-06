package com.Staff.StaffManagent.controller;

import com.Staff.StaffManagent.model.Student;
import com.Staff.StaffManagent.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:5175")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);


    }

    @RequestMapping("/students")
    public List<Student> fetchAllStudents() {
        return studentService.fetchAllStudents();


    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id){
        boolean deleted=false;
        deleted= studentService.deleteStudent(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", deleted);
        return ResponseEntity.ok(response);


    }

    @GetMapping("/students/{id}")
    public  ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student=null;
        student= studentService.getStudentById(id);
        return  ResponseEntity.ok(student);


    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student student){
        student= studentService.updateStudentById(id, student);
        return  ResponseEntity.ok(student);




    }

}
