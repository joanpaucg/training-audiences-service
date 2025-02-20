package com.jp.audiences.service;

import com.jp.audiences.model.Audience;
import com.jp.audiences.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudienceService {
    private AudienceRepository audienceRepository;

    public AudienceService(AudienceRepository audienceRepository) {
        this.audienceRepository = audienceRepository;
    }

    public void createAudience(Audience audience) {
        audienceRepository.save(audience);
        // Create audience
    }
}
