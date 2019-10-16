package com.tavisca.gce.practice.Access.API.Dao;

import com.tavisca.gce.practice.Access.API.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
