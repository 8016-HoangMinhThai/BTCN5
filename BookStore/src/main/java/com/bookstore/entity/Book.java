package com.bookstore.entity;

import com.bookstore.validator.ValidCategoryId;
import com.bookstore.validator.ValidCategoryIdValidator;
import com.bookstore.validator.ValidUserId;
import com.bookstore.validator.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 100, message = "Tiêu đề phải ít hơn 100 ký tự")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Tác giả không được để trống")
    @Size(max = 100, message = "Tên tác giả phải ít hơn 100 ký tự")
    @Column(name = "author")
    private String author;

    @Min(value = 1000, message = "Giá phải lớn hơn hoặc bằng 1000")
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ValidUserId
    private User user;
}
