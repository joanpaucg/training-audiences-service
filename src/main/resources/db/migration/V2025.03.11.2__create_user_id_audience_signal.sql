CREATE TABLE user_id_audience_signal (
    id SERIAL PRIMARY KEY,
    user_id_type TEXT NOT NULL,
    user_id_value TEXT NOT NULL,
    signal TEXT NOT NULL,
    audience_id BIGINT NOT NULL,
    CONSTRAINT fk_audience
        FOREIGN KEY(audience_id)
        REFERENCES audience(id)
);