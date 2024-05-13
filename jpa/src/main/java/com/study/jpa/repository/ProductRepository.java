package com.study.jpa.repository;

import com.study.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { // 엔터티의 타입, 프라이머리키의 타입



}
