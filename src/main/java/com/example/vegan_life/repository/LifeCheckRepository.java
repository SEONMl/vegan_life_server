package com.example.vegan_life.repository;

import com.example.vegan_life.entity.LifeCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifeCheckRepository extends JpaRepository<LifeCheck, Long> {
}
