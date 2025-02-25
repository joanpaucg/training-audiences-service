package com.jp.audiences.infrastructure.outbound.db;

import com.jp.audiences.domain.Audience;
import com.jp.audiences.domain.AudienceRepository;
import com.jp.audiences.infrastructure.outbound.db.jpa.AudienceJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DbAudienceRepository implements AudienceRepository {
    private AudienceJpaRepository audienceJpaRepository;

    public DbAudienceRepository(AudienceJpaRepository audienceJpaRepository) {
        this.audienceJpaRepository = audienceJpaRepository;
    }

    @Override
    public void save(Audience audience) {
        // create audience entity
        // map domain to entity
        // Save audience entity
        //audienceJpaRepository.save(audience);
    }

    @Override
    public List<Audience> getAll() {
        // Get all audience entities
        //audienceJpaRepository.findAll();
        //map entities to domain
        return new ArrayList<>();

    }
}
