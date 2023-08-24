package au.davidwrz.quizapp.modules.question.create.application;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import au.davidwrz.quizapp.modules.question.create.domain.Question;
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.RepositoryGateway;
import au.davidwrz.quizapp.modules.user.register.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateQuestionFacade {

    @Qualifier("createRepositoryGateway")
    private final RepositoryGateway repositoryGateway;
    private final AddQuestionDtoMapper addQuestionDtoMapper;
    private final AddAnswerDtoMapper addAnswerDtoMapper;

    public CreateQuestionFacade(
            RepositoryGateway repositoryGateway,
            AddQuestionDtoMapper addQuestionDtoMapper,
            AddAnswerDtoMapper addAnswerDtoMapper) {
        this.repositoryGateway = repositoryGateway;
        this.addQuestionDtoMapper = addQuestionDtoMapper;
        this.addAnswerDtoMapper = addAnswerDtoMapper;
    }

    public void add(AddQuestionDto questionDto, User user) {
        if (!isAtLeastOneAnswerTrue(questionDto)) {
            throw new InvalidQuestionException("At least one answer has to be correct!");
        }
        Question question = addQuestionDtoMapper.toEntity(questionDto);
        List<Answer> answers = questionDto.getAnswers()
                .stream()
                .map(addAnswerDtoMapper::toEntity)
                .toList();
        answers.forEach(a -> a.setQuestion(question));
        question.setAnswers(answers);
        repositoryGateway.saveQuestion(question, answers);
    }

    private boolean isAtLeastOneAnswerTrue(AddQuestionDto questionDto) {
        return questionDto.getAnswers().stream()
                .anyMatch(AddQuestionDto.AddAnswerDto::correct);
    }
}
