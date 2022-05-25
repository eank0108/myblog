package com.myblog.myblog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@AllArgsConstructor@NoArgsConstructor
public class PostResponseDto {
    private String name;
    private String title;
    private String message;

    public PostResponseDto(Post post) {
        this.name = post.getName();
        this.message = post.getName();
        this.title = post.getTitle();
    }
}
