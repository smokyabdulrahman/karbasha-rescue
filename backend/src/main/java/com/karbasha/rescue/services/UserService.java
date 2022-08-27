package com.karbasha.rescue.services;

import com.karbasha.rescue.common.dto.ErrorType;
import com.karbasha.rescue.common.dto.MeaningfulError;
import com.karbasha.rescue.data.*;
import com.karbasha.rescue.data.entities.pet.*;
import com.karbasha.rescue.data.entities.user.*;
import com.karbasha.rescue.dtos.user.*;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PetRepository petRepository;

    @Transactional
    public UserProfileResponse getUserOrCreate(String username, AccessToken token) {
        try {
            return userRepository.findByUsername(username)
                    .or(() -> Optional.of(createAuthenticatedUser(token)))
                    .map(userProfile -> UserProfileResponse.builder()
                            .user(mapToUserProfileDto(userProfile))
                            .build())
                    .orElseThrow();
        } catch (Exception e) {
            return UserProfileResponse.builder()
                    .meaningfulError(MeaningfulError.of(ErrorType.FAILURE))
                    .build();
        }
    }

    private UserProfile createAuthenticatedUser(AccessToken token) {
        var userProfile = UserProfile.builder()
                .username(token.getPreferredUsername())
                .email(token.getEmail())
                .name(token.getName())
                .build();

        return userRepository.save(userProfile);
    }

    private UserProfileDto mapToUserProfileDto(UserProfile userProfile) {
        var pets = getPetsByOwnerId(userProfile.getId());
        return UserProfileDto.builder()
                .id(userProfile.getId())
                .username(userProfile.getUsername())
                .email(userProfile.getEmail())
                .phone(userProfile.getPhone())
                .age(userProfile.getAge())
                .hasKids(userProfile.isHasKids())
                .monthlyIncome(userProfile.getMonthlyIncome())
                .pets(pets)
                .build();
    }

    private List<Pet> getPetsByOwnerId(UUID ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }

}
