package au.davidwrz.quizapp.modules.quiz.create.application;

import au.davidwrz.quizapp.modules.quiz.create.domain.Answer;
import au.davidwrz.quizapp.modules.quiz.create.domain.Category;
import au.davidwrz.quizapp.modules.quiz.create.domain.Question;
import au.davidwrz.quizapp.modules.quiz.create.domain.Quiz;
import au.davidwrz.quizapp.modules.quiz.create.infrastracture.db.RepositoryGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateQuizFacade {

    private final RepositoryGateway repositoryGateway;
    private final AddQuizDtoMapper mapper;

    public CreateQuizFacade(RepositoryGateway repositoryGateway, AddQuizDtoMapper mapper) {
        this.repositoryGateway = repositoryGateway;
        this.mapper = mapper;
    }

    public void add(AddQuizDto addQuizDto) {
        Quiz quiz = mapper.toEntity(addQuizDto);
        List<Question> questions = quiz.getQuestions();
        List<Answer> answers = quiz.getAllAnswers();
        Category category = quiz.getCategory();
        repositoryGateway.saveQuiz(quiz, category, questions, answers);
    }

}
