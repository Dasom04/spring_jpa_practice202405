package com.study.jpa.chap01_basic.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id // 프라이머리 키가 될거라는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id") // 필드명으로 컬럼을 지정해주고 싶지 않을떄 씀.
    private Long id;

    @Column(name = "prod_name", nullable = false , length = 30) // 컬럼명을 따로 지정하고 Not Null을 해준것.
    private String name;

    private int price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp
    @Column(updatable = false) // insert되면 수정 불가로 하겠다
    private LocalDateTime createDate;

    @UpdateTimestamp // update문 쓸 때 자동으로 들어감
    private LocalDateTime updateDate;

    public enum Category {

        FOOD, FASHION, ELECTRONIC
    }

}