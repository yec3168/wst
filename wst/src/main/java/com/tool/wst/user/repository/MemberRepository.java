package com.tool.wst.user.repository;


import com.tool.wst.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Override
    Optional<Member> findById(Long id);

    Optional<Member> findByEmail(String email);
}
