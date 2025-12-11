package dto;

import lombok.Builder;

@Builder
public class ProfileResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    private String location;
    private String jobTitle;
    private String linkedinUrl;
    private String githubUrl;
    private Long userId; // utile per sapere a quale utente appartiene
}
