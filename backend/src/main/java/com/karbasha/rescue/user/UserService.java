package com.karbasha.rescue.user;

import com.karbasha.rescue.common.dto.ErrorType;
import com.karbasha.rescue.common.dto.MeaningfulError;
import com.karbasha.rescue.user.dto.UserProfileResponse;
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
            return userRepository.findById(username)
                    .or(() -> Optional.of(createAuthenticatedUser(token)))
                    .map(userProfile -> UserProfileResponse.builder()
                            .user(userProfile)
                            .build())
                    .orElseThrow();
        } catch (Exception e){
            return UserProfileResponse.builder()
                    .meaningfulError(MeaningfulError.of(ErrorType.FAILURE))
                    .build();
        }
    }

    private UserProfile createAuthenticatedUser(AccessToken token) {
        var userProfile = new UserProfile();
        userProfile.setUsername(token.getPreferredUsername());
        userProfile.setEmail(token.getEmail());
        userProfile.setName(token.getName());

        return userRepository.save(userProfile);
    }
}
