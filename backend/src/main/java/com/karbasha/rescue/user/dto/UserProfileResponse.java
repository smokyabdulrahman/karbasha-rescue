package com.karbasha.rescue.user.dto;

import com.karbasha.rescue.common.dto.AdditionalStatus;
import com.karbasha.rescue.user.UserProfile;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UserProfileResponse extends AdditionalStatus {
    UserProfile user;
}
