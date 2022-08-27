package com.karbasha.rescue.controllers;

import com.karbasha.rescue.dtos.post.*;
import com.karbasha.rescue.services.*;
import lombok.*;
import org.springframework.http.*;
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
    public ResponseEntity<PostResponse> get(@PathVariable("id") UUID id)
    {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(CreatePostDto post) {
        return ResponseEntity.ok(postService.create(post));
    }
}
