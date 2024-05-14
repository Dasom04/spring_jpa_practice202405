package com.study.jpa.chap02_querymethod.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter // 실무적 측면에서 setter는 신중하게 선택할 것. (직접 변경하고자 하는 필드만 따로 설정하는 경우가 많음.)
// 안정성을 위해, 혹은 setter를 직접 선언하려면 안씀
@Getter @ToString
@EqualsAndHashCode(of = "id") // id가 같으면 같은 객체로 인식. (필드 이름을 써줘야함)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @Column(name = "stu_id")
//    @GeneratedValue(generator = "uid")
//    @GenericGenerator(name = "uid", strategy = "uuid") (과거)
    @GeneratedValue(strategy = GenerationType.UUID) // Spring Boot3에서 JPA를 사용할 때 권장하는 문법. (최신)
    private String id;

    @Column(name = "stu_name" , nullable = false)
    private String name;

    private String city;

    private String major;



}
