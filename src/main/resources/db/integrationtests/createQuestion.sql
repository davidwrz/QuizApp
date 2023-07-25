INSERT INTO question(id, content)
VALUES (1, 'What is the capital of Australia?');

INSERT INTO answer(id, content, correct, question_id)
VALUES (1, 'Melbourne', false, 1),
       (2, 'Sydney', false, 1),
       (3, 'Brisbane', false, 1),
       (4, 'Canberra', true, 1);
