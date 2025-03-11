package com.jp.audiences.infrastructure.outbound.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AudienceJpaRepository extends JpaRepository<AudienceEntity, Long> {
    Optional<AudienceEntity> findByName(String name);
}
