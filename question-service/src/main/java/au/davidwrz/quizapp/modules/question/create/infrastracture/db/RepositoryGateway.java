package au.davidwrz.quizapp.modules.question.create.infrastracture.db;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import au.davidwrz.quizapp.modules.question.create.domain.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("createRepositoryGateway")
public class RepositoryGateway {

    private final AnswerRepository answerRepository;
    @Qualifier("createQuestionRepository")
    private final QuestionRepository questionRepository;

    private RepositoryGateway(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public void saveQuestion(Question question, Iterable<Answer> answers) {
        questionRepository.save(question);
        answerRepository.saveAll(answers);
    }
}
