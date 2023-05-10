package com.miporftolio.ArgProg.service;

import com.miporftolio.ArgProg.model.UserProfile;
import com.miporftolio.ArgProg.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public Optional<UserProfile> findByEmail(String email) {
        return Optional.ofNullable(userProfileRepository.findByEmail(email));
    }

    public UserProfile saveOrUpdate(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
    
    public UserProfile login(String email, String password) {
    UserProfile userProfile = userProfileRepository.findByEmail(email);
    if (userProfile != null && password.equals(userProfile.getPassword())) {
        return userProfile;
    }
    return null;
}
    
    public String getEmail(Long id) {
    Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);
    if (userProfileOptional.isPresent()) {
        return userProfileOptional.get().getEmail();
    }
    return null;
}

    public Long getId(String email) {
    UserProfile userProfile = userProfileRepository.findByEmail(email);
    if (userProfile != null) {
        return userProfile.getId();
    }
    return null;
}
    public Optional<UserProfile> findById(Long id) {
    return userProfileRepository.findById(id);
}
    
}
