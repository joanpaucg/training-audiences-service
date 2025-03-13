package com.jp.audiences.domain;

import java.util.List;

public interface UserIdAudienceSignalRepository {

    void save(UserIdAudienceSignal userIdAudienceSignal);

    List<UserIdAudienceSignal> getAll();
}