package au.davidwrz.quizapp.modules.user.register.application

import jakarta.validation.Validation
import spock.lang.Specification

import jakarta.validation.Validator
import jakarta.validation.ConstraintViolation


class RegisterUserDtoTest extends Specification {

    Validator validator = Validation.buildDefaultValidatorFactory().validator

    def "should pass validation when name and password are valid"() {
        given:
        def validDto = new RegisterUserDto("ValidUser123", "ValidPassword1!")

        when:
        Set<ConstraintViolation<RegisterUserDto>> violations = validator.validate(validDto)

        then:
        violations.isEmpty()
    }

    def "should fail validation when length of name is invalid"() {
        when:
        Set<ConstraintViolation<RegisterUserDto>> violations = validator.validate(new RegisterUserDto("12", "ValidPassword1!"))

        then:
        violations.size() == 1
        violations.first().message == "size must be between 3 and 20"
    }

    def "should fail validation when password is invalid"() {
        when:
        Set<ConstraintViolation<RegisterUserDto>> violations = validator.validate(new RegisterUserDto("ValidUser123", "invalidpassword"))

        then:
        violations.size() == 1
        violations.first().message == "Password is invalid! Password must be at least 8 characters long and contain at least one digit, one uppercase letter, and one special character."
    }
}
