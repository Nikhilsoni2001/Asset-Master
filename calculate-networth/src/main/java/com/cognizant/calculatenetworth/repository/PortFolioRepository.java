package com.cognizant.calculatenetworth.repository;

import com.cognizant.calculatenetworth.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortFolioRepository extends JpaRepository<Portfolio, Integer> {
}
