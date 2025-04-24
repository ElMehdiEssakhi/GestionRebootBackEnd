package com.toto.repository;
import com.toto.entity.Reb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RebRepository extends JpaRepository<Reb, Long> {
    Reb getRebById(Long id);

    List<Reb> findAllByZoneId(String zoneId);
}

