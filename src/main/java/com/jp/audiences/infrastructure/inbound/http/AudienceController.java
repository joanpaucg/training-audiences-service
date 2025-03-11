package com.jp.audiences.infrastructure.inbound.http;

import com.jp.audiences.application.SaveUserIdAudienceSignalUseCase;
import com.jp.audiences.application.GetAudiencesUseCase;
import com.jp.audiences.domain.Audience;
import com.jp.audiences.domain.UserId;
import com.jp.audiences.infrastructure.inbound.http.resource.AudienceResource;
import com.jp.audiences.infrastructure.inbound.http.resource.CreateAudienceRequestResource;
import com.jp.audiences.infrastructure.inbound.http.resource.GetAudiencesResponseResource;
import com.jp.audiences.infrastructure.inbound.http.resource.UserIdResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/audience")
public class AudienceController {
    private SaveUserIdAudienceSignalUseCase saveUserIdAudienceSignalUseCase;
    private GetAudiencesUseCase getAudiencesUseCase;

    public AudienceController(SaveUserIdAudienceSignalUseCase saveUserIdAudienceSignalUseCase, GetAudiencesUseCase getAudiencesUseCase) {
        this.saveUserIdAudienceSignalUseCase = saveUserIdAudienceSignalUseCase;
        this.getAudiencesUseCase = getAudiencesUseCase;
    }

    @PostMapping @ResponseStatus(HttpStatus.ACCEPTED)
    public void createAudience(@RequestBody CreateAudienceRequestResource audienceRequestResource) {
          audienceRequestResource.userIds()
                .forEach(userIdResource -> {
                    saveUserIdAudienceSignalUseCase.execute(audienceRequestResource.audience(), userIdResource.type(), userIdResource.value(), audienceRequestResource.signal());
                });
    }
    @GetMapping
    public GetAudiencesResponseResource getAllAudiences() {
        List<Audience> audiences= getAudiencesUseCase.getAudiences();
        return new GetAudiencesResponseResource(audiences.stream()
                .map(audience -> new AudienceResource(audience.name()))
                .collect(Collectors.toList()));
    }
}
