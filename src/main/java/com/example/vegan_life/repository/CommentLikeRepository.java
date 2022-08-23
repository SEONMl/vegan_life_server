package com.example.vegan_life.repository;

import com.example.vegan_life.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike,Long> {
    Optional<CommentLike> findByCommentsId(Long commentId);
}
