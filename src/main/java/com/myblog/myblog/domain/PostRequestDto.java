package com.myblog.myblog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
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
