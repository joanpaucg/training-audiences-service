package com.jp.audiences.infrastructure.inbound.http.resource;

import java.util.List;

public record CreateAudienceRequestResource(String audience, String signal, List<UserIdResource> userIds) {
}
