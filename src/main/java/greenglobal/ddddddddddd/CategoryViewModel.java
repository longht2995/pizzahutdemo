package greenglobal.ddddddddddd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Default;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import greenglobal.ddddddddddd.entity.Category;
import greenglobal.ddddddddddd.services.CategoryService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CategoryViewModel {
	@WireVariable
	private CategoryService categoryService;
	private List<Category> listCategory = new ArrayList<Category>();
	private Category category = new Category();
	@Init
	public void init() {
		getListCategory();
	}
	public List<Category> getListCategory() {
		return categoryService.findAll();
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	
	public Category getCategory() {
		
		return category;
	}
	public void setCategory(Category category) {
		
		this.category = category;
	}
	@Command
	public void showWindow(@BindingParam("id")@Default(value = "0") Integer id,@BindingParam("vm")Object object) {
		System.out.println("bbbbbbbbb"+object);
		Map<String, Object> map = new HashMap<String, Object>();
		if(id==0) {
			map.put("category", new Category());
		}else {
			map.put("category", categoryService.findOne(id));
		}
		map.put("vm", object);
		Window window = (Window) Executions.createComponents("saveOrUpdate.zul", null, map);
		window.doModal();
	}
	
}
