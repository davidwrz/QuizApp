package au.davidwrz.quizapp.modules.question.create.application;

import au.davidwrz.quizapp.modules.question.create.domain.Answer;
import au.davidwrz.quizapp.modules.question.create.domain.Question;
import au.davidwrz.quizapp.modules.question.create.infrastracture.web.AddQuestionDto;
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.AnswerRepository;
import au.davidwrz.quizapp.modules.question.create.infrastracture.db.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionFacade {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final AddQuestionDtoMapper addQuestionDtoMapper;

    public QuestionFacade(QuestionRepository repository, AnswerRepository answerRepository, AddQuestionDtoMapper addQuestionDtoMapper) {
        this.questionRepository = repository;
        this.answerRepository = answerRepository;
        this.addQuestionDtoMapper = addQuestionDtoMapper;
    }

    public void add(AddQuestionDto questionDto) {
        Question question = addQuestionDtoMapper.toQuestionEntity(questionDto);
        List<Answer> answers = questionDto.getAnswers()
                .stream()
                .map(addQuestionDtoMapper::toAnswerEntity)
                .toList();
        answers.forEach(a -> a.setQuestion(question));
        question.setAnswers(answers);
        questionRepository.save(question);
        answerRepository.saveAll(answers);
    }
}
