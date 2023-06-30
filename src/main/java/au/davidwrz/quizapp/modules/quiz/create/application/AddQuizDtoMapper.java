package au.davidwrz.quizapp.modules.quiz.create.application;

import au.davidwrz.quizapp.modules.quiz.create.domain.*;
import au.davidwrz.quizapp.utils.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class AddQuizDtoMapper implements EntityMapper<Quiz, AddQuizDto> {

    @Override
    public Quiz toEntity(AddQuizDto addQuizDto) {
        List<Answer> answers = addQuizDto.questions().stream()
                .flatMap(question -> question.getAnswers().stream())
                .map(this::toAnswerEntity)
                .toList();
//TODO
//        List<AddQuestionDto> questions = addQuizDto.questions();
//        for (AddQuestionDto questionDto : questions) {
//             question = addQuestionDtoMapper.toEntity(addQuizDto.questions());
//            answers.forEach(a -> a.setQuestion(question));
//            question.setAnswers(answers);
//            Question question = Question.of(questionDto.getContent(),);
//        }
//        Category category = toCategoryEntity(addQuizDto.category(), null);
//        return Quiz.of(category, )
        return null;
    }

    private Category toCategoryEntity(String categoryName, List<Question> questions) {
        Type type = toType(categoryName);
        return Category.of(type, questions);
    }

    private Type toType(String categoryName) {
        try {
            return Type.valueOf(categoryName);
        } catch (IllegalArgumentException e) {
            throw new InvalidQuestionException(categoryName + " does not exist!");
        }
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
