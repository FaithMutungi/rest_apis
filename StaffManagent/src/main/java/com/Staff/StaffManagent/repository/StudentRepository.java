package com.Staff.StaffManagent.repository;

import com.Staff.StaffManagent.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
}
