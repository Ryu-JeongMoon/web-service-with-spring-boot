package org.example.webservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.webservice.dto.PostsResponseDto;
import org.example.webservice.dto.PostsSaveRequestDto;
import org.example.webservice.dto.PostsUpdateRequestDto;
import org.example.webservice.service.PostService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(
            @PathVariable("id") Long id,
            @RequestBody PostsUpdateRequestDto requestDto) {

        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {

        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }
}
