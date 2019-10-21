package com.tavisca.gce.validate.api.dao;

import com.tavisca.gce.validate.api.model.InputDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidateRepo extends JpaRepository<InputDetails, Integer> {
}
