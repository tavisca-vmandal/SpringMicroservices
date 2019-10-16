package com.tavisca.gce.validate.api.dao;

import com.tavisca.gce.validate.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepo extends JpaRepository<Student,Integer> {
}
