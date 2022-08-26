package com.karbasha.rescue.post;

import com.karbasha.rescue.post.dto.*;
import lombok.*;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
@PreAuthorize("hasRole('user')")
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public PostResponse get(@PathVariable("id") UUID id)
    {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostResponse create(CreatePostRequest createPostRequest) {
        return postService.create(createPostRequest);
    }
}
