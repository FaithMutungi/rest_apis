package com.Staff.StaffManagent.services;

import com.Staff.StaffManagent.entity.StudentEntity;
import com.Staff.StaffManagent.model.Student;
import com.Staff.StaffManagent.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements  StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {

        StudentEntity studentEntity= new StudentEntity();// need to copy all the values fron the Student Model into the studentEntity that's interacting with tje db. the Student model is for the UI
        BeanUtils.copyProperties(student, studentEntity);
        studentRepository.save(studentEntity);
        return student;
    }

    @Override
    public List<Student> fetchAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll(); //find all students in the student entity, then convert the list of student entities into a list of student models
        List<Student> students= studentEntities.stream().map(stud->new Student(
                stud.getId(),
                stud.getFirstname(),
                stud.getLastName(),
                stud.getEmailId())).collect(Collectors.toList());

        return students;
    }

    @Override
    public boolean deleteStudent(int id) {
        StudentEntity studentEntity= studentRepository.findById(id).get();
        studentRepository.delete(studentEntity);
        return true;
    }

    @Override
    public Student getStudentById(int id) {
        StudentEntity studentEntity= studentRepository.findById(id).get();
        Student student= new Student();

        BeanUtils.copyProperties(studentEntity, student);

        return student;
    }

    @Override
    public Student updateStudentById(int id, Student student) {
        StudentEntity studentEntity= studentRepository.findById(id).get();
        studentEntity.setEmailId(student.getEmailId());
        studentEntity.setFirstname(student.getFirstname());
        studentEntity.setLastName(student.getLastName());
        studentRepository.save(studentEntity);
        return student;
    }
}
