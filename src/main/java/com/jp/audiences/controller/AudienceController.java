package com.jp.audiences.controller;

import com.jp.audiences.model.Audience;
import com.jp.audiences.service.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/audience")
public class AudienceController {
    private AudienceService audienceService;

    public AudienceController(AudienceService audienceService) {
        this.audienceService = audienceService;
    }



    @PostMapping @ResponseStatus(HttpStatus.ACCEPTED)
    public void createAudience(@RequestBody Audience audience) {
        // Create audience
        audienceService.createAudience(audience);
    }
}
