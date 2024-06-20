package com.bookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name ="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "Tên quyền cho phép tối đa 50 kí tự")
    @NotBlank(message = "Tên quyền không được để trống")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Size(max = 250, message = "Mô tả quyền cho phép tối đa 250 kí tự")
    @Column(name = "description", length = 250)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "role_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
