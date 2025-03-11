package com.jp.audiences.infrastructure.outbound.db;

import com.jp.audiences.domain.Audience;
import com.jp.audiences.domain.AudienceRepository;
import com.jp.audiences.infrastructure.outbound.db.jpa.AudienceEntity;
import com.jp.audiences.infrastructure.outbound.db.jpa.AudienceJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DbAudienceRepository implements AudienceRepository {
    private AudienceJpaRepository audienceJpaRepository;

    public DbAudienceRepository(AudienceJpaRepository audienceJpaRepository) {
        this.audienceJpaRepository = audienceJpaRepository;
    }

    @Override
    public void save(Audience audience) {
        // create audience entity
        AudienceEntity audienceEntity = new AudienceEntity();
        audienceEntity.setName(audience.name());
        audienceEntity.setCreatedAt(audience.createdAt());
        audienceJpaRepository.save(audienceEntity);

    }

    @Override
    public List<Audience> getAll() {
        return audienceJpaRepository.findAll().stream().map(this::toDomain).toList();

    }

    @Override
    public Optional<Audience> getByName(String name) {
        return audienceJpaRepository.findByName(name).map(this::toDomain);
    }

    private Audience toDomain(AudienceEntity audienceEntity) {
        return new Audience(audienceEntity.getName(),audienceEntity.getCreatedAt());
    }
}
