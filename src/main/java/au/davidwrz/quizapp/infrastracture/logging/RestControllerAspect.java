package au.davidwrz.quizapp.infrastracture.logging;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Enumeration;

@Aspect
@Component
class RestControllerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerAspect.class);

    private final HttpServletRequest request;

    RestControllerAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Pointcut(
            "within(au.davidwrz.quizapp.modules.question..*)"
                    + "&&@annotation(org.springframework.web.bind.annotation.PostMapping)"
    )
    public void addPointcut() {
    }

    @Before("addPointcut()")
    public void logAddingMethod(JoinPoint joinPoint) {
        LOGGER.info("User entered a method : " + joinPoint.getSignature().getName());
        if (null != request) {
            LOGGER.info("Method Type : " + request.getMethod());
            LOGGER.info("Request Path info :" + request.getServletPath());
        }
    }

}
