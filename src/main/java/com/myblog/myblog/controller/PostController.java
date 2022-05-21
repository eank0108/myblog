package com.myblog.myblog.controller;

import com.myblog.myblog.domain.Post;
import com.myblog.myblog.domain.PostRepository;
import com.myblog.myblog.domain.PostRequestDto;
import com.myblog.myblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository;
//    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")
    public List<Post> readPost(){
        return postRepository.findAllByOrderByModifiedAtAsc();
    }
}
