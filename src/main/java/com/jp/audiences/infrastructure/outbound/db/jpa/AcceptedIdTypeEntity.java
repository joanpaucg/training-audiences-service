package com.jp.audiences.infrastructure.outbound.db.jpa;

import jakarta.persistence.*;

@Entity(name = "accepted_id_type")
public class AcceptedIdTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_type")
    private String idType;

    @ManyToOne
    @JoinColumn(name = "external_platform_id")
    private ExternalPlatformEntity externalPlatform;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public ExternalPlatformEntity getExternalPlatform() {
        return externalPlatform;
    }

    public void setExternalPlatform(ExternalPlatformEntity externalPlatform) {
        this.externalPlatform = externalPlatform;
    }
}