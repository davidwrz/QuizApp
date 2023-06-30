CREATE TABLE IF NOT EXISTS category
(
    id   SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS question_category
(
    category_id INT NOT NULL,
    question_id INT NOT NULL,
    PRIMARY KEY (category_id, question_id),
    FOREIGN KEY (category_id) REFERENCES category (id),
    FOREIGN KEY (question_id) REFERENCES question (id)
);

CREATE TABLE IF NOT EXISTS quiz
(
    id          SERIAL PRIMARY KEY,
    category_id INT NOT NULL,

    FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS quiz_questions
(
    quiz_id     INT NOT NULL,
    question_id INT NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quiz (id),
    FOREIGN KEY (question_id) REFERENCES question (id)
);