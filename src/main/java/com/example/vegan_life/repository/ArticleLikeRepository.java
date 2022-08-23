package com.example.vegan_life.repository;

import com.example.vegan_life.entity.ArticleLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleLikeRepository extends JpaRepository<ArticleLike, Long>{
    Optional<ArticleLike> findByArticleId(Long articleId);
}
