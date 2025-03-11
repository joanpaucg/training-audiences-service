CREATE TABLE external_platform (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    time_to_start_delivery BIGINT,
    max_ids_per_request BIGINT,
    max_requests_per_time_frame BIGINT,
    time_frame BIGINT
);

CREATE TABLE accepted_id_type (
    id SERIAL PRIMARY KEY,
    id_type VARCHAR(255) NOT NULL,
    external_platform_id BIGINT NOT NULL,
    CONSTRAINT fk_external_platform
        FOREIGN KEY(external_platform_id)
        REFERENCES external_platform(id)
        ON DELETE CASCADE
);

INSERT INTO external_platform (name, time_to_start_delivery, max_ids_per_request, max_requests_per_time_frame, time_frame)
VALUES ('CastlesIds', 30, 1000, 1, 1);

INSERT INTO accepted_id_type (id_type, external_platform_id)
VALUES ('email', (SELECT id FROM external_platform WHERE name = 'CastlesIds'));

INSERT INTO external_platform (name, time_to_start_delivery, max_ids_per_request, max_requests_per_time_frame, time_frame)
VALUES ('MarketingPlus', 30, 1000, 1, 1);

INSERT INTO accepted_id_type (id_type, external_platform_id)
VALUES
('email', (SELECT id FROM external_platform WHERE name = 'MarketingPlus')),
('android.aaid', (SELECT id FROM external_platform WHERE name = 'MarketingPlus')),
('ios.idfa', (SELECT id FROM external_platform WHERE name = 'MarketingPlus')),
('phone', (SELECT id FROM external_platform WHERE name = 'MarketingPlus'));