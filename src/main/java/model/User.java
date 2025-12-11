package model; // lo usiamo per mappare una tabella

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String role;
    private Boolean enabled;
}
