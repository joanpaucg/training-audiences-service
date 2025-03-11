package com.jp.audiences.domain;

import java.time.LocalDateTime;
import java.util.List;

public record Audience(String name, LocalDateTime createdAt) {
}
