package com.myblog.myblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

//    @ColumnTransformer(
//            read = "decrypt(pw)",
//            write = "encrypt(nvl(?, 'null'))"
//    )
    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String message;

    public Post(PostRequestDto requestDto) {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.pw = requestDto.getPw();
        this.message = requestDto.getMessage();
    }
    public void update(PostRequestDto requestDto) {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.pw = requestDto.getPw();
        this.message = requestDto.getMessage();
    }

}
