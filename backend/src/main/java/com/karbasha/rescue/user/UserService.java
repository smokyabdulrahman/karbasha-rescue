package com.karbasha.rescue.user;

import com.karbasha.rescue.common.dto.ErrorType;
import com.karbasha.rescue.common.dto.MeaningfulError;
import com.karbasha.rescue.user.dto.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserProfileResponse getUserOrCreate(String username, AccessToken token) {
        try {
            return getUser(username);
        } catch (EntityNotFoundException e) {
            return createAuthenticatedUser(token);
        } catch (Exception e){
            return UserProfileResponse.builder()
                    .meaningfulError(MeaningfulError.of(ErrorType.FAILURE))
                    .build();
        }
    }

    private UserProfileResponse getUser(String id) {
        var userProfile = userRepository.getReferenceById(id);

        return UserProfileResponse.builder()
                .user(userProfile)
                .build();
    }

    private UserProfileResponse createAuthenticatedUser(AccessToken token) {
        var user = userRepository.save(UserProfile.builder()
                        .username(token.getPreferredUsername())
                        .email(token.getEmail())
                        .name(token.getName())
                .build());

        return UserProfileResponse.builder()
                .user(user)
                .build();
    }
}
