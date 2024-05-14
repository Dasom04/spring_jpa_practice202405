package com.study.jpa.chap04_relation.retository;

import com.study.jpa.chap04_relation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query("SELECT d FROM Department d JOIN FETCH d.employees") // 엔터티 클래스 이름으로 써줘야함
    List<Department> findAllIncludesEmployees();




}
