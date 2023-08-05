package au.davidwrz.quizapp.modules.question.create.infrastracture.db

import au.davidwrz.quizapp.modules.question.create.domain.Answer
import au.davidwrz.quizapp.modules.question.create.domain.Question
import spock.lang.Specification

class RepositoryGatewayTest extends Specification {

    def answerRepository = Mock(AnswerRepository)
    def questionRepository = Mock(QuestionRepository)
    def repositoryGateway = new RepositoryGateway(answerRepository, questionRepository)

    def "should save question and answers to repository"() {
        given:
        def answers = List.of(
                new Answer(
                        content: "Melbourne",
                        correct: false
                ),
                new Answer(
                        content: "Perth",
                        correct: false
                ),
                new Answer(
                        content: "Canberra",
                        correct: true
                ),
                new Answer(
                        content: "Sydney",
                        correct: false
                )
        )
        def question = new Question(
                id: 1,
                content: "What is the capital of Australia?",
                answers: answers
        )
        when:
        repositoryGateway.saveQuestion(question, answers)

        then:
        1 * questionRepository.save(question)
        1 * answerRepository.saveAll(answers)
    }
}
