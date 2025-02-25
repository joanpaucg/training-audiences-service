package com.jp.audiences.application;

import com.jp.audiences.domain.Audience;
import com.jp.audiences.domain.AudienceRepository;
import org.springframework.stereotype.Service;

// Input port implementation of creation use case
@Service
public class CreateAudienceUseCase {
    private AudienceRepository audienceRepository;

    public CreateAudienceUseCase(AudienceRepository audienceRepository) {
        this.audienceRepository = audienceRepository;
    }

    public void createAudience(Audience audience) {
        // Create audience
        audienceRepository.save(audience);
    }

}
