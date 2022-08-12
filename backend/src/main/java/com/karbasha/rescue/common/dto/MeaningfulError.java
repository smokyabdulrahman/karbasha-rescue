package com.karbasha.rescue.common.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MeaningfulError(ErrorType errorType, String message) {
    public static MeaningfulError of(@NonNull ErrorType errorType) {
        return MeaningfulError.builder().errorType(errorType).message(errorType.getDisplayMessage()).build();
    }
}
