package com.bookstore.repository;

import com.bookstore.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
