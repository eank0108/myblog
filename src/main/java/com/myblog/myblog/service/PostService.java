package com.myblog.myblog.service;

import com.myblog.myblog.domain.Post;
import com.myblog.myblog.domain.PostRepository;
import com.myblog.myblog.domain.PostRequestDto;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository=postRepository;
    }
    public List<Post> readPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    public PostRequestDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRequestDto = new PostRequestDto(postRepository.save(post));
        return postRequestDto;
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
        System.out.println(post.toString());
        System.out.println(postRequestDto.getPw());
        if (!post.getPw().equals(postRequestDto.getPw())) {
            throw new RuntimeException("비밀번호 틀림");
        }
        postRepository.deleteById(id);
        return id;
    }
}
