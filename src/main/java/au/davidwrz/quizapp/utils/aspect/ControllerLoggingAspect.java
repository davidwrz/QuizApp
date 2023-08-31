package au.davidwrz.quizapp.utils.aspect;

import au.davidwrz.quizapp.modules.user.register.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
class ControllerLoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLoggingAspect.class);
    private final ObjectMapper mapper;

    ControllerLoggingAspect(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Pointcut("within(au.davidwrz.quizapp.modules.question..*) && @within(org.springframework.web.bind.annotation.RestController)")
    public void restControllerMethods() {
    }

    @AfterReturning(pointcut = "restControllerMethods()", returning = "entity")
    public void logControllerMethod(JoinPoint joinPoint, ResponseEntity<?> entity) {
        String className = joinPoint.getTarget().getClass().getSimpleName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        try {
            LOGGER.info("<== Controller: {}, User: {}, Method: {}, Returning: {}",
                    className, user.getUsername(), joinPoint.getSignature().getName(),
                    mapper.writeValueAsString(entity));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error while converting", e);
        }
    }
}
