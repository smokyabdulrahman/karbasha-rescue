package com.karbasha.rescue.services;

import com.karbasha.rescue.data.*;
import com.karbasha.rescue.data.entities.post.*;
import com.karbasha.rescue.dtos.post.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostResponse getPostById(UUID id) {
        return postRepository.findById(id)
                .map(p -> PostResponse.builder()
                        .post(p)
                        .build())
                .orElseThrow();
    }

    public PostResponse create(Post post) {
        var createdPost = postRepository.save(post);

        return PostResponse.builder()
                .post(createdPost)
                .build();
    }
}
