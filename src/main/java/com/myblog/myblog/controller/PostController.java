package com.myblog.myblog.controller;

import com.myblog.myblog.domain.Post;
import com.myblog.myblog.domain.PostRepository;
import com.myblog.myblog.domain.PostRequestDto;
import com.myblog.myblog.domain.PostResponseDto;
import com.myblog.myblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")

public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostResponseDto> readPosts(){
        return postService.readPosts();
    }

    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    @PutMapping("/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody Map<String,Object> map) {
        return postService.updatePost(id, map);
    }

    @DeleteMapping("/post/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.deletePost(id,postRequestDto);
    }


}

