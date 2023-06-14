CREATE TABLE IF NOT EXISTS question (
    id INT PRIMARY KEY,
    content VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS answer (
    id INT PRIMARY KEY,
    content VARCHAR(255) NOT NULL,
    correct BOOLEAN NOT NULL,
    question_id INTEGER,

    FOREIGN KEY (question_id) REFERENCES question(id)
)
