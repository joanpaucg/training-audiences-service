package com.jp.audiences.repository.impl;

import com.jp.audiences.model.Audience;
import com.jp.audiences.repository.AudienceRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FakeAudienceRepository implements AudienceRepository {
    @Override
    public void save(Audience audience) {
        // Save audience
        System.out.println("Audience saved: " + audience);
    }
}
