package com.jp.audiences.application;

import com.jp.audiences.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaveUserIdAudienceSignalUseCase {
    private final AudienceRepository audienceRepository;
    private final UserIdAudienceSignalRepository userIdAudienceSignalRepository;

    public SaveUserIdAudienceSignalUseCase(AudienceRepository audienceRepository, UserIdAudienceSignalRepository userIdAudienceSignalRepository) {
        this.audienceRepository = audienceRepository;
        this.userIdAudienceSignalRepository = userIdAudienceSignalRepository;
    }

    public void execute(String audienceName, String userIdType, String userIdValue, String signal) {
        Audience audience = audienceRepository.getByName(audienceName).orElseGet(() -> createAudience(audienceName));
        saveUserIdAudienceSignal(userIdType, userIdValue, signal, audience);
    }

    private Audience createAudience(String audienceName) {
        Audience audience = new Audience(audienceName, LocalDateTime.now());
        audienceRepository.save(audience);
        return audience;
    }

    private void saveUserIdAudienceSignal(String userIdType, String userIdValue, String signal, Audience audience) {
        UserId userId = new UserId(userIdType, userIdValue);
        Signal signalObj = Signal.valueOf(signal);
        UserIdAudienceSignal userIdAudienceSignal = new UserIdAudienceSignal(userId, audience, signalObj);
        userIdAudienceSignalRepository.save(userIdAudienceSignal);
    }
}
