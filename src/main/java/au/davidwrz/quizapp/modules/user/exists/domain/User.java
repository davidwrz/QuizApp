package au.davidwrz.quizapp.modules.user.exists.domain;

import jakarta.persistence.*;

@Entity(name = "existsUser")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }
}
