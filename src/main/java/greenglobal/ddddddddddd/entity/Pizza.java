package greenglobal.ddddddddddd.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pizza")
public class Pizza implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String image;
	@OneToMany
	private List<Material> listMaterial;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Size size;
	private Double price;
	@Transient
	private boolean check;
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
	public List<Material> getListMaterial() {
		return listMaterial;
	}
	public void setListMaterial(List<Material> listMaterial) {
		this.listMaterial = listMaterial;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Pizza(Integer id, String name, String image, List<Material> listMaterial, Size size, Double price,
			boolean check) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.listMaterial = listMaterial;
		this.size = size;
		this.price = price;
		this.check = check;
	}
	public Pizza() {
		
	}
	
}
