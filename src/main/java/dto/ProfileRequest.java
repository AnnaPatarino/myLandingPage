package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequest {
    private String firstName;
    private String lastName;
    private String bio;
    private String location;
    private String jobTitle;
    private String linkedinUrl;
    private String githubUrl;
}