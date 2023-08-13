package au.davidwrz.quizapp.modules.security

import au.davidwrz.quizapp.security.JWTUtil
import spock.lang.Specification

class JWTUtilTest extends Specification {

    def "should issue a valid token with subject"() {
        given:
        JWTUtil jwtUtil = new JWTUtil()
        String subject = "testuser"

        when:
        String token = jwtUtil.issueToken(subject)

        then:
        jwtUtil.isTokenValid(token, subject)
    }

    def "should issue a valid token with subject and custom claims"() {
        given:
        JWTUtil jwtUtil = new JWTUtil()
        String subject = "testuser"
        def customClaims = [ "customKey": "customValue" ]

        when:
        String token = jwtUtil.issueToken(subject, customClaims)

        then:
        jwtUtil.isTokenValid(token, subject)
    }

    def "should return subject from token"() {
        given:
        JWTUtil jwtUtil = new JWTUtil()
        String subject = "testuser"
        String token = jwtUtil.issueToken(subject)

        when:
        String extractedSubject = jwtUtil.getSubject(token)

        then:
        extractedSubject == subject
    }

    def "should validate a valid token for the same subject"() {
        given:
        JWTUtil jwtUtil = new JWTUtil()
        String subject = "testuser"
        String token = jwtUtil.issueToken(subject)

        when:
        boolean isValid = jwtUtil.isTokenValid(token, subject)

        then:
        isValid
    }
}
