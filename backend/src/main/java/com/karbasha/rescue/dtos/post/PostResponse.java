package com.karbasha.rescue.dtos.post;

import com.karbasha.rescue.common.dto.*;
import com.karbasha.rescue.data.entities.post.*;
import lombok.*;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public class PostResponse extends AdditionalStatus {
    Post post;
}
