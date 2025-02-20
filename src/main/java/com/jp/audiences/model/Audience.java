package com.jp.audiences.model;

import java.util.List;

public record Audience(String name, List<UserId> userIds) {
}
