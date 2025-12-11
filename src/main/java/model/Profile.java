package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String bio;
    private String location;
    private String jobTitle;
    private String linkedinUrl;
    private String githubUrl;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
