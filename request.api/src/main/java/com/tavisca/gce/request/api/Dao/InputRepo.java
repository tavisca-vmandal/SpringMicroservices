package com.tavisca.gce.request.api.Dao;

import com.tavisca.gce.request.api.Model.Input;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InputRepo extends JpaRepository<Input, Integer> {
}
