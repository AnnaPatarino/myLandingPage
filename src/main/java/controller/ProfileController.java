package controller;

import dto.ProfileRequest;
import dto.ProfileResponse;
import lombok.RequiredArgsConstructor;
import model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.impl.ProfileService;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/create")
    public ResponseEntity<ProfileResponse> createProfile(
            @RequestBody ProfileRequest request,
            @RequestParam Long userId) {
        Profile profile = profileService.createProfile(request, userId);
        ProfileResponse response = ProfileResponse.builder()
                .id(profile.getId())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .bio(profile.getBio())
                .location(profile.getLocation())
                .jobTitle(profile.getJobTitle())
                .linkedinUrl(profile.getLinkedinUrl())
                .githubUrl(profile.getGithubUrl())
                .userId(profile.getUser().getId())
                .build();
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ProfileResponse> updateProfile(
            @PathVariable Long id,
            @RequestBody ProfileRequest request){

        Profile profile = profileService.updateProfile(id, request);

        ProfileResponse response = ProfileResponse.builder()
                .id(profile.getId())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .bio(profile.getBio())
                .location(profile.getLocation())
                .jobTitle(profile.getJobTitle())
                .linkedinUrl(profile.getLinkedinUrl())
                .githubUrl(profile.getGithubUrl())
                .userId(profile.getUser().getId())
                .build();


        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
