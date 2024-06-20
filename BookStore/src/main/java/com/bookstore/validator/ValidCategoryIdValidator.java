package com.bookstore.validator;


import com.bookstore.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category>
{
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext)
    {
        return category!=null  && category.getId() !=null;
    }
}
