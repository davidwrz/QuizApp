package au.davidwrz.quizapp.modules.quiz.create.application;

import au.davidwrz.quizapp.modules.quiz.create.domain.*;
import au.davidwrz.quizapp.utils.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
class AddQuizDtoMapper implements EntityMapper<Quiz, AddQuizDto> {

    @Override
    public Quiz toEntity(AddQuizDto addQuizDto) {
        List<Question> questions = addQuizDto.questions().stream()
                .map(this::mapToAddQuestion)
                .collect(Collectors.toList());

        Category category = toCategoryEntity(addQuizDto.category(), questions);

        List<Answer> allAnswers = questions.stream()
                .flatMap(question -> question.getAnswers().stream())
                .collect(Collectors.toList());

        setQuestionReferences(allAnswers, questions);

        return Quiz.of(category, questions);
    }

    private Question mapToAddQuestion(AddQuestionDto addQuestionDto) {
        List<Answer> answers = addQuestionDto.getAnswers().stream()
                .map(this::toAnswerEntityFromAddAnswerDto)
                .collect(Collectors.toList());

        Question question = Question.of(addQuestionDto.getContent());
        question.setAnswers(answers);
        return question;
    }


    private void setQuestionReferences(List<Answer> allAnswers, List<Question> questions) {
        Map<Integer, Question> questionMap = questions.stream()
                .collect(Collectors.toMap(Question::getId, Function.identity()));

        allAnswers.forEach(answer -> {
            Integer questionId = answer.getQuestion().getId();
            Question mappedQuestion = questionMap.get(questionId);
            answer.setQuestion(mappedQuestion);
        });
    }

    private Category toCategoryEntity(String categoryName, List<Question> questions) {
        Type type = toType(categoryName);
        Category category = Category.of(type, questions);
        questions.forEach(question -> question.getCategories().add(category));
        return category;
    }

    private Type toType(String categoryName) {
        try {
            return Type.valueOf(categoryName);
        } catch (IllegalArgumentException e) {
            throw new InvalidQuestionException(categoryName + " does not exist!");
        }
    }

    private Answer toAnswerEntityFromAddAnswerDto(AddQuestionDto.AddAnswerDto addAnswerDto) {
        return Answer.of(addAnswerDto.answer(), addAnswerDto.correct());
    }

    private Answer toAnswerEntity(AddQuestionDto.AddAnswerDto addAnswerDto) {
        return Answer.of(addAnswerDto.answer(), addAnswerDto.correct());
    }

    private static class InvalidQuestionException extends RuntimeException {
        public InvalidQuestionException(String message) {
            super(message);
        }
    }
}
