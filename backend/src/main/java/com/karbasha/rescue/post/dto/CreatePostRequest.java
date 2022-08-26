package com.karbasha.rescue.post.dto;

import lombok.*;

import java.net.*;
import java.util.*;

@Builder
@Value
public class CreatePostRequest {
    UUID userId;
    UUID petId;
    String title;
    String description;
    URL locationUrl;
    URL imageUrl;
}
