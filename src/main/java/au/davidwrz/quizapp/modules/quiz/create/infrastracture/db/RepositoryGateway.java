package au.davidwrz.quizapp.modules.quiz.create.infrastracture.db;

import au.davidwrz.quizapp.modules.quiz.create.domain.Answer;
import au.davidwrz.quizapp.modules.quiz.create.domain.Category;
import au.davidwrz.quizapp.modules.quiz.create.domain.Question;
import au.davidwrz.quizapp.modules.quiz.create.domain.Quiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CREATE_QUIZ_REPOSITORY_GATEWAY")
public class RepositoryGateway {

    private final QuizRepository quizRepository;
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public RepositoryGateway(QuizRepository quizRepository,
                             CategoryRepository categoryRepository,
                             QuestionRepository questionRepository,
                             AnswerRepository answerRepository) {
        this.quizRepository = quizRepository;
        this.categoryRepository = categoryRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Transactional
    public void saveQuiz(Quiz quiz, Category category, List<Question> questions, List<Answer> answers) {
        quizRepository.save(quiz);
        categoryRepository.save(category);
        questionRepository.saveAll(questions);
        answerRepository.saveAll(answers);
    }
}
