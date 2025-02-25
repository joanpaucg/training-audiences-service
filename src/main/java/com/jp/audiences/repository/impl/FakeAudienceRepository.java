package com.jp.audiences.repository.impl;

import com.jp.audiences.domain.Audience;
import com.jp.audiences.domain.AudienceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FakeAudienceRepository implements AudienceRepository {
    private Map<String, Audience> audiences=new HashMap<>();
    @Override
    public void save(Audience audience) {
        // Save audience
        System.out.println("Audience saved: " + audience);
        audiences.put(audience.name(), audience);
    }

    @Override
    public List<Audience> getAll() {
        return new ArrayList<>(audiences.values());
    }
}
