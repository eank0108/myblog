package com.myblog.myblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String title;
    @Column
    private String pw;
    @Column
    private String message;
//    @CreationTimestamp
//    @Column
//    private Timestamp createTime;
//    @UpdateTimestamp
//    @Column
//    private Timestamp  updateTime;

    public Post(PostRequestDto postRequestDto) {
        this.name = postRequestDto.getName();
        this.title = postRequestDto.getTitle();
        this.pw = postRequestDto.getPw();
        this.message = postRequestDto.getMessage();
    }
    public void updatePost(Map<String,Object> map) {

        for( String key : map.keySet() ){
            if (key == "message") {
                message = (String) map.get(key);
            }
            if (key == "title") {
                title = (String) map.get(key);
            }
        }
//        this.name = postRequestDto.getName();
//        this.title = postRequestDto.getTitle();
//        this.pw = postRequestDto.getPw();
//        this.message = postRequestDto.getMessage();
    }

}
