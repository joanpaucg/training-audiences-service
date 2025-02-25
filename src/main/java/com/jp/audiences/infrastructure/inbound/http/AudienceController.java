package com.jp.audiences.infrastructure.inbound.http;

import com.jp.audiences.application.CreateAudienceUseCase;
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
    private CreateAudienceUseCase createAudienceUseCase;
    private GetAudiencesUseCase getAudiencesUseCase;

    public AudienceController(CreateAudienceUseCase createAudienceUseCase, GetAudiencesUseCase getAudiencesUseCase) {
        this.createAudienceUseCase = createAudienceUseCase;
        this.getAudiencesUseCase = getAudiencesUseCase;
    }

    @PostMapping @ResponseStatus(HttpStatus.ACCEPTED)
    public void createAudience(@RequestBody CreateAudienceRequestResource audienceRequestResource) {
        List<UserId> userIds = audienceRequestResource.userIds().stream()
                .map(userIdResource -> new UserId(userIdResource.type(),userIdResource.value()))
                .collect(Collectors.toList());
        Audience audience = new Audience(audienceRequestResource.audience(), userIds);
        // Create audience
        createAudienceUseCase.createAudience(audience);
    }
    @GetMapping
    public GetAudiencesResponseResource getAllAudiences() {
        List<Audience> audiences= getAudiencesUseCase.getAudiences();
        return new GetAudiencesResponseResource(audiences.stream()
                .map(audience -> new AudienceResource(audience.name(),
                        audience.userIds().stream()
                                .map(userId -> new UserIdResource(userId.type(), userId.value()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList()));
    }
}
