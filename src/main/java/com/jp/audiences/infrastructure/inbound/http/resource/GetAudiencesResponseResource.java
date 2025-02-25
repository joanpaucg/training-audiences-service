package com.jp.audiences.infrastructure.inbound.http.resource;

import java.util.List;

public record GetAudiencesResponseResource(List<AudienceResource> audiences) {
}
