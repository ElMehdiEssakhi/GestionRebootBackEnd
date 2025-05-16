package com.toto.repository;

import com.toto.entity.Technician;
import com.toto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Technician findByName(String name);

    void deleteByName(String name);

    void removeTechnicianByName(String name);
}
