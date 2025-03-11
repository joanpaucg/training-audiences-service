package com.jp.audiences.domain;


import com.jp.audiences.domain.Audience;

import java.util.List;
import java.util.Optional;

public interface AudienceRepository {
    void save(Audience audience);
    List<Audience> getAll();
    Optional<Audience> getByName(String name);
}
