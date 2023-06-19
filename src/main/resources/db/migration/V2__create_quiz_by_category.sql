CREATE TABLE IF NOT EXISTS category (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS quiz (
    id SERIAL PRIMARY KEY,
    category_id INT NOT NULL,

    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS quiz_questions (
    quiz_id INT NOT NULL,
    questions_id INT NOT NULL,

    FOREIGN KEY (quiz_id) REFERENCES quiz(id),
    FOREIGN KEY (questions_id) REFERENCES question(id)
);