package com.tavisca.gce.practice.Save.API.Dao;


import com.tavisca.gce.practice.Save.API.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
