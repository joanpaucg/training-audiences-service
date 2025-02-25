package com.jp.audiences.domain;


import com.jp.audiences.domain.Audience;

import java.util.List;

public interface AudienceRepository {
    void save(Audience audience);
    List<Audience> getAll();
}
