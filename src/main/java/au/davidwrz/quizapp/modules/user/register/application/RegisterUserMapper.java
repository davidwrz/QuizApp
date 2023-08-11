package au.davidwrz.quizapp.modules.user.register.application;

import au.davidwrz.quizapp.modules.user.register.domain.User;
import au.davidwrz.quizapp.utils.mapper.EntityMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class RegisterUserMapper implements EntityMapper<User, RegisterUserDto> {

    private final PasswordEncoder passwordEncoder;

    RegisterUserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User toEntity(RegisterUserDto userDto) {
        return User.of(userDto.name(), passwordEncoder.encode(userDto.password()));
    }
}
