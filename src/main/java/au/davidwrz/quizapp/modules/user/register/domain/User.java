package au.davidwrz.quizapp.modules.user.register.domain;

import jakarta.persistence.*;

@Entity(name = "createUser")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public User() {
    }

    public String getName() {
        return name;
    }

    private User(String name) {
        this.name = name;
    }

    public static User of(String name) {
        return new User(name);
    }
}
