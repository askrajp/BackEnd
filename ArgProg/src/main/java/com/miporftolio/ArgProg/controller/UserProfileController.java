package com.miporftolio.ArgProg.controller;

import com.miporftolio.ArgProg.model.UserProfile;
import com.miporftolio.ArgProg.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

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
        UserProfile authenticatedUserProfile = userProfileService.login(loginUser.getEmail(), loginUser.getPassword());
        if (authenticatedUserProfile != null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("userId", authenticatedUserProfile.getId());
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
