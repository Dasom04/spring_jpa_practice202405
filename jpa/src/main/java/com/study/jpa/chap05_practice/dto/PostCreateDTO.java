package com.study.jpa.chap05_practice.dto;

import com.study.jpa.chap05_practice.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Setter @Getter @ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCreateDTO {

    // @NotNull -> null을 허용하지 않음 "", " " 허용
    // @NotEmpty -> null,


    @NotBlank // null, 빈 문자, 공백 모두 허용하지 않음
    @Size(min = 2, max = 5)
    private String writer;

    @NotBlank
    @Size(min = 1, max = 20)
    private String title;

    private String content;

    private List<String> hashTag;

    // dto를 entity로 변환하는 메서드
    public Post toEntity() {
        return Post.builder()
                .writer(this.writer)
                .title(this.title)
                .content(this.content)
                // hashTag는 여기에 넣는게 아니다. (DB에 없음!)
                .build();
    }



}