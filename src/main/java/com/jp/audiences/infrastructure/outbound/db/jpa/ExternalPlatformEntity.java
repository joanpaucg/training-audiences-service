package com.jp.audiences.infrastructure.outbound.db.jpa;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "external_platform")
public class ExternalPlatformEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "time_to_start_delivery")
    private Long timeToStartDelivery;

    @Column(name = "max_ids_per_time_frame")
    private Long maxIdsPerTimeFrame;

    @Column(name = "max_requests_per_time_frame")
    private Long maxRequestsPerTimeFrame;

    @OneToMany(mappedBy = "externalPlatform", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AcceptedIdTypeEntity> acceptedIdTypes;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimeToStartDelivery() {
        return timeToStartDelivery;
    }

    public void setTimeToStartDelivery(Long timeToStartDelivery) {
        this.timeToStartDelivery = timeToStartDelivery;
    }

    public Long getMaxIdsPerTimeFrame() {
        return maxIdsPerTimeFrame;
    }

    public void setMaxIdsPerTimeFrame(Long maxIdsPerTimeFrame) {
        this.maxIdsPerTimeFrame = maxIdsPerTimeFrame;
    }

    public Long getMaxRequestsPerTimeFrame() {
        return maxRequestsPerTimeFrame;
    }

    public void setMaxRequestsPerTimeFrame(Long maxRequestsPerTimeFrame) {
        this.maxRequestsPerTimeFrame = maxRequestsPerTimeFrame;
    }

    public List<AcceptedIdTypeEntity> getAcceptedIdTypes() {
        return acceptedIdTypes;
    }

    public void setAcceptedIdTypes(List<AcceptedIdTypeEntity> acceptedIdTypes) {
        this.acceptedIdTypes = acceptedIdTypes;
    }
}