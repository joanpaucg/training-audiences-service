package com.jp.audiences.infrastructure.outbound.db;

import com.jp.audiences.domain.UserIdAudienceSignal;
import com.jp.audiences.domain.UserIdAudienceSignalRepository;
import com.jp.audiences.infrastructure.outbound.db.jpa.AudienceEntity;
import com.jp.audiences.infrastructure.outbound.db.jpa.AudienceJpaRepository;
import com.jp.audiences.infrastructure.outbound.db.jpa.UserIdAudienceSignalEntity;
import com.jp.audiences.infrastructure.outbound.db.jpa.UserIdAudienceSignalJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DbUserIdAudienceSignalRepository implements UserIdAudienceSignalRepository {
    private final UserIdAudienceSignalJpaRepository userIdAudienceSignalJpaRepository;
    private final AudienceJpaRepository audienceJpaRepository;

    public DbUserIdAudienceSignalRepository(UserIdAudienceSignalJpaRepository userIdAudienceSignalJpaRepository, AudienceJpaRepository audienceJpaRepository) {
        this.userIdAudienceSignalJpaRepository = userIdAudienceSignalJpaRepository;
        this.audienceJpaRepository = audienceJpaRepository;
    }

    @Override
    public void save(UserIdAudienceSignal userIdAudienceSignal) {
        UserIdAudienceSignalEntity userIdAudienceSignalEntity = new UserIdAudienceSignalEntity();
        userIdAudienceSignalEntity.setUserIdType(userIdAudienceSignal.userId().type());
        userIdAudienceSignalEntity.setUserIdValue(userIdAudienceSignal.userId().value());
        userIdAudienceSignalEntity.setSignal(userIdAudienceSignal.signal().name());
        AudienceEntity audienceEntity = audienceJpaRepository.findByName(userIdAudienceSignal.audience().name()).orElseThrow();
        userIdAudienceSignalEntity.setAudience(audienceEntity);
        userIdAudienceSignalJpaRepository.save(userIdAudienceSignalEntity);
    }

    @Override
    public List<UserIdAudienceSignal> getAll() {
        return new ArrayList<>();
    }
}
