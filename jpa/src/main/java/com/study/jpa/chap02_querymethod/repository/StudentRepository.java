package com.study.jpa.chap02_querymethod.repository;

import com.study.jpa.chap02_querymethod.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByName(String name); // 메서드 이름이 쿼리문을 정한다.

    List<Student> findByCityAndMajor(String city, String major);

    List<Student> findByMajorContaining(String major); //Containing -> like절로 변환된다.

    // 네이티브 쿼리 사용
    @Query(value = "SELECT * FROM tbl_student WHERE stu_name = :nm", nativeQuery = true)
    List<Student> findNameWithSql(@Param("nm") String name);

}
