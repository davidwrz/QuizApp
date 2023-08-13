package au.davidwrz.quizapp.modules.user.login.application

import jakarta.validation.ConstraintViolation
import jakarta.validation.Validation
import jakarta.validation.Validator
import spock.lang.Specification

class LoginUserDtoTest extends Specification {

    Validator validator = Validation.buildDefaultValidatorFactory().validator

    def "should pass validation when name and password are valid"() {
        given:
        def validDto = new LoginUserDto("ValidUser123", "ValidPassword1!")

        when:
        Set<ConstraintViolation<LoginUserDto>> violations = validator.validate(validDto)

        then:
        violations.isEmpty()
    }

    def "should fail validation when name is null"() {
        when:
        Set<ConstraintViolation<LoginUserDto>> violations = validator.validate(new LoginUserDto(null, "ValidPassword1!"))

        then:
        violations.size() == 1
        violations.first().message == "may not be null"
    }

    def "should fail validation when name length is invalid"() {
        when:
        Set<ConstraintViolation<LoginUserDto>> violations = validator.validate(new LoginUserDto("12", "ValidPassword1!"))

        then:
        violations.size() == 1
        violations.first().message == "size must be between 3 and 20"
    }

    def "should fail validation when password is null"() {
        when:
        Set<ConstraintViolation<LoginUserDto>> violations = validator.validate(new LoginUserDto("ValidUser123", null))

        then:
        violations.size() == 1
        violations.first().message == "may not be null"
    }
}
