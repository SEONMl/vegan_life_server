package com.example.vegan_life.repository;

import com.example.vegan_life.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Long> {

    // 나중에 QueryDSL로 수정
    @Query(value = "SELECT * FROM comment WHERE article_id=:article_id", nativeQuery = true)
    public Optional<List<Comments>> findAllByArticleId(@Param("article_id")Long article_id);
}
