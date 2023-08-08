package au.davidwrz.quizapp.modules.user.register.application;

import au.davidwrz.quizapp.modules.user.exists.application.ExistsUserFacade;
import au.davidwrz.quizapp.modules.user.register.application.security.JWTUtil;
import au.davidwrz.quizapp.modules.user.register.domain.User;
import au.davidwrz.quizapp.modules.user.register.infrastructure.db.RepositoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserFacade {

    @Qualifier("createUserGateway")
    private final RepositoryGateway repositoryGateway;
    private final ExistsUserFacade existsUserFacade;
    private final RegisterUserMapper registerUserMapper;
    private final JWTUtil jwtUtil;

    public RegisterUserFacade(RepositoryGateway repositoryGateway, ExistsUserFacade existsUserFacade, RegisterUserMapper registerUserMapper, JWTUtil jwtUtil) {
        this.repositoryGateway = repositoryGateway;
        this.existsUserFacade = existsUserFacade;
        this.registerUserMapper = registerUserMapper;
        this.jwtUtil = jwtUtil;
    }

    public String register(RegisterUserDto userDto) {
        if (existsUserFacade.existsUser(userDto.name())) {
            throw new AlreadyRegisteredUserException(userDto.name());
        }
        User user = registerUserMapper.toEntity(userDto);
        repositoryGateway.registerUser(user);
        return jwtUtil.issueToken("username", "ROLE_USER");
    }
}
