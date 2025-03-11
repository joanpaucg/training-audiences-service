package com.jp.audiences.application;

import com.jp.audiences.domain.Audience;
import com.jp.audiences.domain.AudienceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// Input port implementation of creation use case
@Service
public class SaveUserIdAudienceSignalUseCase {
    private AudienceRepository audienceRepository;

    public SaveUserIdAudienceSignalUseCase(AudienceRepository audienceRepository) {
        this.audienceRepository = audienceRepository;
    }

    public void execute(String audienceName, String userIdType, String userIdValue, String signal) {
        Audience audience = audienceRepository.getByName(audienceName).orElse(createAudience(audienceName));

    }
    private Audience createAudience(String audienceName) {
        Audience audience= new Audience(audienceName, LocalDateTime.now());
        audienceRepository.save(audience);
        return audience;
    }

}
