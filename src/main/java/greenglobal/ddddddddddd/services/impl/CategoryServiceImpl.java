package greenglobal.ddddddddddd.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greenglobal.ddddddddddd.entity.Category;
import greenglobal.ddddddddddd.services.CategoryService;
@Service("categoryService")

public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}
	public Category findOne(Integer id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}
	public void saveOrUpdate(Category category) {
		// TODO Auto-generated method stub
		categoryDao.add(category);
	}

}
