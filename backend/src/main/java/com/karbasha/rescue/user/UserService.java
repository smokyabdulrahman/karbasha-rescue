package com.karbasha.rescue.user;

import com.karbasha.rescue.common.dto.ErrorType;
import com.karbasha.rescue.common.dto.MeaningfulError;
import com.karbasha.rescue.pet.dto.*;
import com.karbasha.rescue.user.dto.*;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class UserService {

    private final UserRepository userRepository;

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
        return UserProfileDto.builder()
                .id(userProfile.getId())
                .username(userProfile.getUsername())
                .email(userProfile.getEmail())
                .phone(userProfile.getPhone())
                .age(userProfile.getAge())
                .hasKids(userProfile.isHasKids())
                .monthlyIncome(userProfile.getMonthlyIncome())
                .pets(userProfile.getPets().stream()
                        .map(p -> PetDto.builder()
                                .id(p.getId())
                                .name(p.getName())
                                .age(p.getAge())
                                .country(p.getCountry())
                                .city(p.getCity())
                                .gender(p.getGender())
                                .healthCondition(p.getHealthCondition())
                                .neutered(p.getNeutered())
                                .picture(p.getPicture())
                                .vaccinated(p.getVaccinated())
                                .personalityDescription(p.getPersonalityDescription())
                        .build())
                        .toList())
                .build();
    }
}
