package com.example.vegan_life.repository;

import com.example.vegan_life.entity.DietEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<DietEntity,Long> {
}
