package com.karbasha.rescue.user.dto;

import com.karbasha.rescue.common.dto.AdditionalStatus;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class UserProfileResponse extends AdditionalStatus {
    UserProfileDto user;
}
