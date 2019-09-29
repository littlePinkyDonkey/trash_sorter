package com.trash_sorter.service;

import com.trash_sorter.model.Category;

import java.util.List;

public interface CategoryService {
    boolean addNewCategory(Category catName);
    boolean deleteCategory(Category cat);
    Category getCategoryById(long id);
    List<String> getCategoriesName();
    List<Category> getAllCategories();
    List<Category> getAllCategoryByTankId(long tankId);
}
