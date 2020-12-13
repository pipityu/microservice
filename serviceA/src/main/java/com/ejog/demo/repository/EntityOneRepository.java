package com.ejog.demo.repository;

import com.ejog.demo.model.EntityOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityOneRepository extends JpaRepository<EntityOne, Integer> {
}
