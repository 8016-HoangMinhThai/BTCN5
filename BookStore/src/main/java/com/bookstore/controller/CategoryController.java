package com.bookstore.controller;

import com.bookstore.entity.Category;
import com.bookstore.services.CategoryServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping()
    public String showAllCategories(Model model) {
        List<Category> categories = categoryServices.getAllCategories();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/add";
        }
        categoryServices.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryServices.getCategoryById(id);
        if (category != null) {
            model.addAttribute("category", category);
            return "Category/edit";
        }
        return "redirect:/categories";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String updateCategory(@PathVariable("id") Long id, @Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/edit";
        }
        categoryServices.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryServices.deleteCategory(id);
        return "redirect:/categories";
    }
}
