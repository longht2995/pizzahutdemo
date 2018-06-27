package greenglobal.ddddddddddd;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import greenglobal.ddddddddddd.entity.Category;
import greenglobal.ddddddddddd.entity.Material;
import greenglobal.ddddddddddd.entity.Pizza;
import greenglobal.ddddddddddd.entity.Size;
import greenglobal.ddddddddddd.services.CategoryService;
import greenglobal.ddddddddddd.services.MaterialService;
import greenglobal.ddddddddddd.services.PizzaService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {

	@WireVariable
	private PizzaService pizzaService;
	@WireVariable
	private MaterialService materialService;
	@WireVariable
	private CategoryService categoryService;
	private List<Pizza> listPizza;
	private List<Material> listMaterial;
	private Pizza pickPizza;
	private Size size;
	private List<Material> pickMaterial;
	private List<Category> listCategory;
	private boolean rootPizza;
	private boolean rootMaterial;
	private Double price = 20.0;
	private Integer quantity = 1;
	@Init
	public void init() {
		listPizza = new ArrayList<Pizza>();
		listMaterial = new ArrayList<Material>();
		listCategory = new ArrayList<Category>();
		size = new Size();
		listPizza = pizzaService.getAll();
		pickMaterial = new ArrayList<Material>();
		pickPizza = new Pizza();
		listCategory = categoryService.findAll();
		rootPizza = true;
		pickPizza = pizzaService.getOne(2);
		checkPickPizza();
	}
	
	public List<Pizza> getListPizza() {
		return listPizza;
	}

	public void setListPizza(List<Pizza> listPizza) {
		this.listPizza = listPizza;
	}

	public List<Material> getListMaterial() {
		return listMaterial;
	}

	public void setListMaterial(List<Material> listMaterial) {
		this.listMaterial = listMaterial;
	}

	public Pizza getPickPizza() {
		return pickPizza;
	}

	public void setPickPizza(Pizza pickPizza) {
		this.pickPizza = pickPizza;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public List<Material> getPickMaterial() {
		return pickMaterial;
	}

	public void setPickMaterial(List<Material> pickMaterial) {
		this.pickMaterial = pickMaterial;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public boolean isRootPizza() {
		return rootPizza;
	}

	public void setRootPizza(boolean rootPizza) {
		this.rootPizza = rootPizza;
	}

	public boolean isRootMaterial() {
		
		return rootMaterial;
	}

	public void setRootMaterial(boolean rootMaterial) {
		this.rootMaterial = rootMaterial;
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	@NotifyChange("price")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
		totalPrice();
	}
	@Command
	@NotifyChange({"pickMaterial","listMaterial","price"})
	public void pickerMaterial(@BindingParam("material")Material material) {
		int quantity = 0;
		for(int i = 0;i <= pickMaterial.size()-1;i++) {
			if(material.getId() == pickMaterial.get(i).getId()) {
				quantity++;
			}
		}
		
		if(quantity==2) {
			for(int i = 0; i<= pickMaterial.size()-1 ; i++) {
				if(pickMaterial.get(i).getId() == material.getId()) {
					pickMaterial.remove(i);
					pickMaterial.remove(material);
				}
			}
		}else {
			pickMaterial.add(material);
		}
		resetAndActive();
		totalPrice();
	}
	@Command
	@NotifyChange({"listMaterial","listPizza","rootPizza","rootMaterial"})
	public void selectCategory(@BindingParam("id")Integer id) {
		rootPizza = false;
		rootMaterial = true;
		listMaterial = materialService.findByCategory(id);
		resetAndActive();
	}
	@Command
	@NotifyChange("*")
	public void pickPizza(@BindingParam("pizza")Pizza pizza) {
		pickPizza = pizza;
		pickMaterial = new ArrayList<Material>(pickPizza.getListMaterial());
		resetAndActive();
		checkPickPizza();
		totalPrice();
	}
	@Command
	@NotifyChange({"rootPizza","rootMaterial"})
	public void showPizzas() {
		rootMaterial = false;
		rootPizza=true;
	}
	@NotifyChange("listMaterial")
	public void resetAndActive() {
		int sizeList = listMaterial.size();
		for(int i = 0;i<sizeList;i++) {
			listMaterial.get(i).setCheck(0);
		}
		int sizePick = pickMaterial.size();
		for(int i =0;i < sizePick;i++) {
			for(int j =0;j<sizeList;j++) {
				if(pickMaterial.get(i).getId()==listMaterial.get(j).getId()) {
					Integer a = listMaterial.get(j).getCheck();
					listMaterial.get(j).setCheck(a+1);
					if(listMaterial.get(j).getCheck()==3) {
						listMaterial.get(j).setCheck(0);
						
					}
				}
			}
		}
		
	}
	@NotifyChange("price")
	public void totalPrice() {
		price = 0.0;
		price += pickPizza.getPrice();
		int sizePick = pickMaterial.size();
		for(int i = 0 ;i<sizePick;i++) {
			price += pickMaterial.get(i).getPrice();
		}
		price *=Double.valueOf(quantity);
	}
	public void checkPickPizza() {
		int sizePizza = listPizza.size();
		for(int i =0;i<sizePizza;i++) {
			listPizza.get(i).setCheck(false);
		}
		
		for(int i =0;i<sizePizza;i++) {
			if(pickPizza.getId()==listPizza.get(i).getId()) {
				listPizza.get(i).setCheck(true);
				break;
			}
			
		}
	}
}
