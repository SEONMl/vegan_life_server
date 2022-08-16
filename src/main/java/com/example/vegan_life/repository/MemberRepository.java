package com.example.vegan_life.repository;

import com.example.vegan_life.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select * from member m where email=:email", nativeQuery = true)
    Optional<Member> findByEmail(@Param("email") String email);
}

