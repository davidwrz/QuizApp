package au.davidwrz.quizapp.modules.user.login.application;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginUserDto(@Size(min = 3, max = 20) @NotNull String name, @NotNull String password) {
}
