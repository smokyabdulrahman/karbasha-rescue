package com.karbasha.rescue.post.dto;

import com.karbasha.rescue.common.dto.*;
import com.karbasha.rescue.post.*;
import lombok.*;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public class PostResponse extends AdditionalStatus {
    Post post;
}
