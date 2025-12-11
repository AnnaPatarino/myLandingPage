package service.impl;

import dto.ProfileRequest;
import model.Profile;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProfileRepository;
import repository.UserRepository;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    UserRepository userRepository;

    public Profile createProfile(ProfileRequest request, Long userId) {
     Optional<User> user = userRepository.findById(userId);
     if(user.isEmpty()){
         throw new RuntimeException("User not found");
     }
     Optional<Profile> profile = profileRepository.findByUserId(userId);
     if(profile.isPresent()){
         throw new RuntimeException("Profile exists for this user");
     }

        Profile newProfile = Profile.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .bio(request.getBio())
                .jobTitle(request.getJobTitle())
                .githubUrl(request.getGithubUrl())
                .linkedinUrl(request.getLinkedinUrl())
                .user(user.get()).build();

        return profileRepository.save(newProfile);
    }

    public Profile updateProfile(Long profileId, ProfileRequest request){

            Optional<Profile> profile = profileRepository.findById(profileId);
            if(profile.isEmpty()){
                throw new RuntimeException("Profile not found");
            }
            Profile updatingProfile = profile.get();
            updatingProfile.setBio(request.getBio());
            updatingProfile.setLocation(request.getLocation());
            updatingProfile.setGithubUrl(request.getGithubUrl());
            updatingProfile.setLinkedinUrl(request.getLinkedinUrl());

            return profileRepository.save(updatingProfile);
    }

}
