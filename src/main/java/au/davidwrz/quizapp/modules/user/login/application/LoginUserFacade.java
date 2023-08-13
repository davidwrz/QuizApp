package au.davidwrz.quizapp.modules.user.login.application;

import au.davidwrz.quizapp.modules.user.register.domain.User;
import au.davidwrz.quizapp.security.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginUserFacade {

    private final AuthenticationManager authenticationManager;
    private final LoginUserMapper loginUserMapper;
    private final JWTUtil jwtUtil;

    public LoginUserFacade(AuthenticationManager authenticationManager,
                           LoginUserMapper loginUserMapper,
                           JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.loginUserMapper = loginUserMapper;
        this.jwtUtil = jwtUtil;
    }

    public LoginUserResponse login(LoginUserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.name(), userDto.password())
        );
        User principal = (User) authentication.getPrincipal();
        LoggedUserDto user = loginUserMapper.toDto(principal);

        String jwt = jwtUtil.issueToken(user.name());

        return new LoginUserResponse(jwt, user);
    }

}
