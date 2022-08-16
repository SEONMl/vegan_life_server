package com.example.vegan_life.repository;

import com.example.vegan_life.entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet,Long> {
}
