package com.example.vegan_life.repository;

import com.example.vegan_life.entity.RecipeLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeLikeRepository extends JpaRepository<RecipeLike,Long> {
    Optional<List<RecipeLike>> findByMember(Long id);
}
