package com.myblog.myblog.service;

import com.myblog.myblog.domain.Post;
import com.myblog.myblog.domain.PostRepository;
import com.myblog.myblog.domain.PostRequestDto;
import com.myblog.myblog.domain.PostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository=postRepository;
    }
    public List<PostResponseDto> readPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        postRequestDto.setMessage(postRequestDto.getMessage().replace("\n","<br>"));
        Post post = new Post(postRequestDto);
        PostResponseDto postResponseDto = new PostResponseDto(postRepository.save(post));
        return postResponseDto;
    }

    @Transactional
    public Long updatePost(Long id, Map<String,Object> map) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NullPointerException("Post가 없습니다."));
        if (!post.getPw().equals(map.get("pw"))) {
            throw new RuntimeException("비밀번호 틀림");
        }
        post.updatePost(map);
        return id;
    }

    public Long deletePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NullPointerException("Post가 없습니다."));
        if (!post.getPw().equals(postRequestDto.getPw())) {
            throw new RuntimeException("비밀번호 틀림");
        }
        postRepository.deleteById(id);
        return id;
    }
}
