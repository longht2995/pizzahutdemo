package greenglobal.ddddddddddd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import greenglobal.ddddddddddd.CategoryViewModel;
import greenglobal.ddddddddddd.services.CategoryService;

@Entity
@Table(name="category")
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category() {
		
	}
	@Transient
	@WireVariable
	private CategoryService categoryService;
	@Command
	public void add(@BindingParam("category")Category category,@BindingParam("vm")Object object) {
		System.out.println("Category here:"+object);
		Category c = new Category();
		c.setId(category.getId());
		c.setName(category.getName());
		categoryService.saveOrUpdate(c);
		BindUtils.postNotifyChange(null, null, object, "*");
	}
	
}
