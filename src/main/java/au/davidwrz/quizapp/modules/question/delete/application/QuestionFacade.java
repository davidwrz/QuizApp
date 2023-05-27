package au.davidwrz.quizapp.modules.question.create.application;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import au.davidwrz.quizapp.modules.question.create.domain.Question;
import au.davidwrz.quizapp.modules.question.create.infrastracture.web.AddQuestionDto;
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.AnswerRepository;
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.QuestionRepository;
import au.davidwrz.quizapp.modules.question.create.infrastracture.web.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionFacade {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final Mapper mapper;

    public QuestionFacade(QuestionRepository repository, AnswerRepository answerRepository, Mapper mapper) {
        this.questionRepository = repository;
        this.answerRepository = answerRepository;
        this.mapper = mapper;
    }

    public void add(AddQuestionDto questionDto) {
        Question question = mapper.toQuestionEntity(questionDto);
        List<Answer> answers = questionDto.getAnswers()
                .stream()
                .map(mapper::toAnswerEntity)
                .toList();
        answers.forEach(a -> a.setQuestion(question));
        question.setAnswers(answers);
        questionRepository.save(question);
        answerRepository.saveAll(answers);
    }
}
