package au.davidwrz.quizapp.modules.user.register.application

import au.davidwrz.quizapp.modules.user.exists.application.ExistsUserFacade
import au.davidwrz.quizapp.modules.user.register.domain.User
import au.davidwrz.quizapp.modules.user.register.infrastructure.db.RepositoryGateway
import au.davidwrz.quizapp.security.JWTUtil
import spock.lang.Specification

class RegisterUserFacadeTest extends Specification {

    def gateway = Mock(RepositoryGateway)
    def existsUserFacade = Mock(ExistsUserFacade)
    def mapper = Mock(RegisterUserMapper)
    def jwtUtil = Mock(JWTUtil)
    def facade = new RegisterUserFacade(gateway, existsUserFacade, mapper, jwtUtil)

    def "should return valid token after registration"() {
        given:
        String name = "testuser"
        String password = "Testpassword1!"
        User user = new User(name: name, password: password)

        RegisterUserDto userDto = new RegisterUserDto(name, password)

        when:
        String resultToken = facade.register(userDto)

        then:
        existsUserFacade.existsUser(userDto.name()) >> false
        mapper.toEntity(userDto) >> user
        jwtUtil.issueToken(name, "ROLE_USER") >> "example_token"

        resultToken == "example_token"
    }

    def "should throw exception when user already registered"() {
        given:
        String name = "testuser"
        String password = "Testpassword1!"

        RegisterUserDto userDto = new RegisterUserDto(name, password)

        when:
        facade.register(userDto)

        then:
        existsUserFacade.existsUser(userDto.name()) >> true
        thrown(AlreadyRegisteredUserException)
    }
}
