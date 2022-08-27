package com.karbasha.rescue.dtos.post;

import com.karbasha.rescue.common.dto.*;
import com.karbasha.rescue.data.entities.post.*;
import lombok.*;
import lombok.experimental.*;

@Value
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class PostResponse extends AdditionalStatus {
    Post post;
}
