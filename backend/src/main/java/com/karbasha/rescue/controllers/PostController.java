package com.karbasha.rescue.controllers;

import com.karbasha.rescue.data.entities.post.*;
import com.karbasha.rescue.dtos.post.*;
import com.karbasha.rescue.services.*;
import com.karbasha.rescue.util.*;
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
    public PostResponse create(@Dto(CreatePostDto.class) Post post) {
        return postService.create(post);
    }
}
