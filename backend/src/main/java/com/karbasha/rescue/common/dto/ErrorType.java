package com.karbasha.rescue.common.dto;

import lombok.Getter;
import lombok.NonNull;

public enum ErrorType {
    DUPLICATE("The entity you are trying to create exists"),
    USER_NOT_HERE("There isn't any user with this id."),
    FAILURE("Something has gone wrong");

    @Getter
    private final @NonNull String displayMessage;

    private ErrorType(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
