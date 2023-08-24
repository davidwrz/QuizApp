CREATE TABLE IF NOT EXISTS competition
(
    id      SERIAL PRIMARY KEY,
    user_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS attempt
(
    id             SERIAL PRIMARY KEY,
    question_id    INT     NOT NULL,
    correct        BOOLEAN NOT NULL,
    competition_id INT,
    attempt_timestamp TIMESTAMP,
    FOREIGN KEY (competition_id) REFERENCES competition (id)
);

CREATE UNIQUE INDEX unique_attempt_in_competition ON attempt (competition_id, question_id);
