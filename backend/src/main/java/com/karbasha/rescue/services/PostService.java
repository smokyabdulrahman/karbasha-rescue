package com.karbasha.rescue.services;

import com.karbasha.rescue.data.*;
import com.karbasha.rescue.data.entities.post.*;
import com.karbasha.rescue.dtos.post.*;
import com.karbasha.rescue.exceptions.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PetRepository petRepository;

    public PostResponse getPostById(UUID id) {
        return postRepository.findById(id)
                .map(p -> PostResponse.builder()
                        .post(p)
                        .build())
                .orElseThrow();
    }

    public PostResponse create(CreatePostDto createPostDto) {
        var user = userRepository.findById(createPostDto.getUserId());
        if (user.isEmpty()) {
            throw new RecordNotFoundException("User not found with id: " + createPostDto.getUserId());
        }

        var pet = petRepository.findById(createPostDto.getPetId());
        if (pet.isEmpty()) {
            throw new RecordNotFoundException("Pet not found with id: " + createPostDto.getPetId());
        }

        var post = Post.builder()
                .title(createPostDto.getTitle())
                .description(createPostDto.getDescription())
                .user(user.get())
                .pet(pet.get())
                .locationLink(createPostDto.getLocationUrl())
                .imageUrl(createPostDto.getImageUrl())
                .type(createPostDto.getType())
                .build();
        var createdPost = postRepository.save(post);

        return PostResponse.builder()
                .post(createdPost)
                .build();
    }
}
