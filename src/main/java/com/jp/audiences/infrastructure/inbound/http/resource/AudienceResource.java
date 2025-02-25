package com.jp.audiences.infrastructure.inbound.http.resource;

import java.util.List;

public record AudienceResource(String name, List<UserIdResource> userIds) {
}
