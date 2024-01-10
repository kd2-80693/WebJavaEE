package com.app.services;

import com.app.dto.CategoryDTO;
import com.app.entities.Category;

public interface CategoryService {
	Category save(CategoryDTO category);
}
