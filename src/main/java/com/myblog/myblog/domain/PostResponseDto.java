package com.myblog.myblog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@AllArgsConstructor@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String name;
    private String title;
    private String message;
    private long createdAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.name = post.getName();
        this.message = post.getMessage();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
    }
}
