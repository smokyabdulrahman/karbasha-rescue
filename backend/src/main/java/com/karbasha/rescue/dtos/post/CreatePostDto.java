package com.karbasha.rescue.dtos.post;

import com.karbasha.rescue.data.entities.post.*;
import lombok.*;

import java.net.*;
import java.util.*;

@Builder
@Value
public class CreatePostDto {
    UUID userId;
    UUID petId;
    String title;
    String description;
    URL locationUrl;
    URL imageUrl;
    PostType type;
}
