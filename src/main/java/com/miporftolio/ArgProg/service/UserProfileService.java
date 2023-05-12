package com.miporftolio.ArgProg.service;

import com.miporftolio.ArgProg.model.UserProfile;
import com.miporftolio.ArgProg.repository.UserProfileRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
     public UserDetails loadUserByEmail(String email) {
        UserProfile userProfile = userProfileRepository.findByEmail(email);
        if (userProfile == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return User.withUsername(userProfile.getEmail())
                .password(userProfile.getPassword())
                .authorities(new ArrayList<>())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
