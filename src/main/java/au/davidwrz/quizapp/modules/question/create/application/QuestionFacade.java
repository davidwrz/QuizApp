package au.davidwrz.quizapp.modules.question.create.application;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import au.davidwrz.quizapp.modules.question.create.domain.Question;
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.RepositoryGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionFacade {

    private final RepositoryGateway repositoryGateway;
    private final AddQuestionDtoMapper addQuestionDtoMapper;
    private final AddAnswerDtoMapper addAnswerDtoMapper;

    public QuestionFacade(
            RepositoryGateway repositoryGateway,
            AddQuestionDtoMapper addQuestionDtoMapper,
            AddAnswerDtoMapper addAnswerDtoMapper) {
        this.repositoryGateway = repositoryGateway;
        this.addQuestionDtoMapper = addQuestionDtoMapper;
        this.addAnswerDtoMapper = addAnswerDtoMapper;
    }

    public void add(AddQuestionDto questionDto) {
        Question question = addQuestionDtoMapper.toEntity(questionDto);
        List<Answer> answers = questionDto.getAnswers()
                .stream()
                .map(addAnswerDtoMapper::toEntity)
                .toList();
        answers.forEach(a -> a.setQuestion(question));
        question.setAnswers(answers);
        repositoryGateway.saveQuestion(question, answers);
    }
}
