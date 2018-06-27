package greenglobal.ddddddddddd.services;

import java.util.List;

import greenglobal.ddddddddddd.entity.Category;

public interface CategoryService {
	public List<Category> findAll();
	public Category findOne(Integer id);
	public void saveOrUpdate(Category category);
}
