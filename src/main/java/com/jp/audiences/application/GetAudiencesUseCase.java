package com.jp.audiences.application;

import com.jp.audiences.domain.Audience;
import com.jp.audiences.domain.AudienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GetAudiencesUseCase {
    private AudienceRepository audienceRepository;

    public GetAudiencesUseCase(AudienceRepository audienceRepository) {
        this.audienceRepository = audienceRepository;
    }

    public List<Audience> getAudiences() {
        // Get audiences
        return audienceRepository.getAll();
    }
}
