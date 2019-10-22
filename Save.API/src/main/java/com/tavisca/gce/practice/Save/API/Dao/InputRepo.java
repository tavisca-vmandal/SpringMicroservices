package com.tavisca.gce.practice.Save.API.Dao;

import com.tavisca.gce.practice.Save.API.Model.InputDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepo extends JpaRepository<InputDetails, Integer> {
}
