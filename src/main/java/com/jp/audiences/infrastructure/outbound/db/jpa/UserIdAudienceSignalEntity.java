package com.jp.audiences.infrastructure.outbound.db.jpa;

import jakarta.persistence.*;

@Entity(name = "user_id_audience_signal")
public class UserIdAudienceSignalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id_type")
    private String userIdType;

    @Column(name = "user_id_value")
    private String userIdValue;

    private String signal;

    @ManyToOne
    @JoinColumn(name = "audience_id", nullable = false)
    private AudienceEntity audience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserIdType() {
        return userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getUserIdValue() {
        return userIdValue;
    }

    public void setUserIdValue(String userIdValue) {
        this.userIdValue = userIdValue;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public AudienceEntity getAudience() {
        return audience;
    }

    public void setAudience(AudienceEntity audience) {
        this.audience = audience;
    }
}