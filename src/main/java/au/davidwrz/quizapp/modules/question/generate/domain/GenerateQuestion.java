package au.davidwrz.quizapp.modules.question.generate.domain;

import au.davidwrz.quizapp.modules.question.create.application.AddQuestionDto;
import au.davidwrz.quizapp.modules.question.create.application.CreateQuestionFacade;
import au.davidwrz.quizapp.modules.question.generate.application.GenerateQuestionDto;
import au.davidwrz.quizapp.modules.question.generate.application.GenerateQuestionDtoMapper;
import au.davidwrz.quizapp.modules.user.register.domain.User;
import org.springframework.stereotype.Service;

@Service
public class GenerateQuestion {

    private final GenerateQuestionDtoMapper mapper;
    private final ExternalApiCaller externalApiCaller;
    private final CreateQuestionFacade createQuestionFacade;

    public GenerateQuestion(GenerateQuestionDtoMapper mapper, ExternalApiCaller externalApiCaller, CreateQuestionFacade createQuestionFacade) {
        this.mapper = mapper;
        this.externalApiCaller = externalApiCaller;
        this.createQuestionFacade = createQuestionFacade;
    }

    public GenerateQuestionDto generateQuestionFromExternalApi(User user, String token) {
        GenerateQuestionDto questionDto = externalApiCaller.generateQuestion(token);
        persistQuestionInDB(user, questionDto);
        return questionDto;
    }

    private void persistQuestionInDB(User user, GenerateQuestionDto questionDto) {
        AddQuestionDto addQuestionDto = mapper.toDto(questionDto);
        createQuestionFacade.add(addQuestionDto, user);
    }
}
