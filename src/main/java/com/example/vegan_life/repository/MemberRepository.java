package com.example.vegan_life.repository;

import com.example.vegan_life.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    @Query(value = "select * from member m where email=:email", nativeQuery = true)
    MemberEntity findByEmail(@Param("email") String email);
}

