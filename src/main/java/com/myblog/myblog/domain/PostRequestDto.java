package com.myblog.myblog.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String name;
    private String title;
    private String pw;
    private String message;
}
