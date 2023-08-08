package au.davidwrz.quizapp.modules.user.register.application;

import au.davidwrz.quizapp.modules.user.register.domain.User;
import au.davidwrz.quizapp.utils.mapper.EntityMapper;
import org.springframework.stereotype.Service;

@Service
class RegisterUserMapper implements EntityMapper<User, RegisterUserDto> {
    @Override
    public User toEntity(RegisterUserDto userDto) {
        return User.of(userDto.name());
    }
}
