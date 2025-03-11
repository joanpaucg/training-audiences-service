package com.jp.audiences.infrastructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.jp.audiences.infrastructure.outbound.db.jpa")
@EntityScan(basePackages = "com.jp.audiences.infrastructure.outbound.db.jpa")
public class JpaConfiguration {
}
