package nagarro.exitassignment.productCatalogue.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private int imgid;
	private String img;
	private String name;
	private String description;
	private String brand;
	private String price;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int imgid, String img, String name, String description, String brand, String price) {
		super();
		this.imgid = imgid;
		this.img = img;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}

	public int getImgid() {
		return imgid;
	}

	public void setImgid(int imgid) {
		this.imgid = imgid;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [imgid=" + imgid + ", img=" + img + ", name=" + name + ", description=" + description
				+ ", brand=" + brand + ", price=" + price + "]";
	}
	
	
		
}