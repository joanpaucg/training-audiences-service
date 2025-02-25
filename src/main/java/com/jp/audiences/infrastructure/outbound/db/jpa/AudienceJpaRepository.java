package com.jp.audiences.infrastructure.outbound.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AudienceJpaRepository extends JpaRepository<AudienceEntity, Long> {
}
