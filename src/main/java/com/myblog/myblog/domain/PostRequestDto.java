package com.myblog.myblog.domain;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostRequestDto {

    private String name;
    private String title;
    private String pw;
    private String message;
    public PostRequestDto(Post post){
        this.name = post.getName();
        this.title = post.getTitle();
        this.pw = post.getPw();
        this.message = post.getMessage();
    }
}
