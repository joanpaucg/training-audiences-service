package com.jp.audiences.domain;

import java.util.List;

public record Audience(String name, List<UserId> userIds) {
}
