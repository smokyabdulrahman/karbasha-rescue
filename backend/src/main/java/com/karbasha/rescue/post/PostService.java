package com.karbasha.rescue.post;

import com.karbasha.rescue.post.dto.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponse getPostById(UUID id) {
        return postRepository.findById(id)
                .map(p -> PostResponse.builder()
                        .post(p)
                        .build())
                .orElseThrow();
    }

    public PostResponse create(CreatePostRequest createPostRequest) {
        var post = postRepository.save(Post.builder()
                        .description(createPostRequest.getDescription())
                .build());

        return PostResponse.builder()
                .post(post)
                .build();
    }
}
