package au.davidwrz.quizapp.modules.user.login.application;

import au.davidwrz.quizapp.modules.user.register.domain.User;
import au.davidwrz.quizapp.utils.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
class LoginUserMapper implements DtoMapper<User, LoggedUserDto> {

    @Override
    public LoggedUserDto toDto(User user) {
        return new LoggedUserDto(user.getName());
    }
}
