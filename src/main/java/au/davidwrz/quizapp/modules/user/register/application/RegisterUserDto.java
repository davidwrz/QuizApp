package au.davidwrz.quizapp.modules.user.register.application;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterUserDto(@Size(min = 3, max = 20) @NotNull String name) {
}
