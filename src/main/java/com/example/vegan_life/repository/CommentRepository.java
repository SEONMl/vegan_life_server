package com.example.vegan_life.repository;

import com.example.vegan_life.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comments,Long> {

    public Optional<List<Comments>> findAllByArticleId(Long article_id);
}
