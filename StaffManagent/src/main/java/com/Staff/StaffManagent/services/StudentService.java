package com.Staff.StaffManagent.services;

import com.Staff.StaffManagent.model.Student;

import java.util.List;

public interface StudentService {
   public Student saveStudent(Student student);

   public List<Student> fetchAllStudents();

   public boolean deleteStudent(int id);

   public Student getStudentById(int id);

  public Student updateStudentById(int id, Student student);
}
