package com.miporftolio.ArgProg.controller;

import com.miporftolio.ArgProg.model.UserProfile;
import com.miporftolio.ArgProg.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.miporftolio.ArgProg.util.JwtUtil;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;
    
    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/info")
    public ResponseEntity<UserProfile> getUserInfo(Principal principal) {
        UserProfile userProfile = userProfileService.findByEmail(principal.getName())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return ResponseEntity.ok(userProfile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long id) {
        UserProfile userProfile = userProfileService.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return ResponseEntity.ok(userProfile);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserProfile> updateUserInfo(@PathVariable Long userId, @RequestBody UserProfile userProfile) {
        UserProfile currentUserProfile = userProfileService.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        currentUserProfile.setOccupation(userProfile.getOccupation());
        currentUserProfile.setResidence(userProfile.getResidence());
        currentUserProfile.setMobilityAvailability(userProfile.isMobilityAvailability());
        currentUserProfile.setDescription(userProfile.getDescription());

        UserProfile updatedUserProfile = userProfileService.saveOrUpdate(currentUserProfile);
        return ResponseEntity.ok(updatedUserProfile);
    }

 @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody UserProfile loginUser) {
    UserProfile userDetails;
    try {
        userDetails = userProfileService.findByEmail(loginUser.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + loginUser.getEmail()));
    } catch (UsernameNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    if (!loginUser.getPassword().equals(userDetails.getPassword())) {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    Map<String, Object> responseBody = new HashMap<>();
    responseBody.put("userId", userDetails.getId());
    String jwt = jwtUtil.generateToken(loginUser.getEmail());
    responseBody.put("jwt", jwt);
    return new ResponseEntity<>(responseBody, HttpStatus.OK);
}
}
