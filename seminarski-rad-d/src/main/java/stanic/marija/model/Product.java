package stanic.marija.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final int type_food = 0;
	public static final int type_animal = 1;
	public static final int other = 2;

	public String getTypeValue() {
		switch (this.type) {
		case type_food:
			return "Food";
		case type_animal:
			return "Animal";
		case other:
			return "Other";
		default:
			return "Invalid type";
		}
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private String note;

	private double price;

	private String size;

	private int type;

	private double weight;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	private Supplier supplier;

	//bi-directional many-to-one association to RequisitionProduct
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<RequisitionProduct> requisitionProducts;

	//bi-directional many-to-one association to Stock
	@JsonIgnore
	@Cascade(CascadeType.REMOVE)
	@OneToMany(mappedBy="product")
	private List<Stock> stocks;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<RequisitionProduct> getRequisitionProducts() {
		return this.requisitionProducts;
	}

	public void setRequisitionProducts(List<RequisitionProduct> requisitionProducts) {
		this.requisitionProducts = requisitionProducts;
	}

	public RequisitionProduct addRequisitionProduct(RequisitionProduct requisitionProduct) {
		getRequisitionProducts().add(requisitionProduct);
		requisitionProduct.setProduct(this);

		return requisitionProduct;
	}

	public RequisitionProduct removeRequisitionProduct(RequisitionProduct requisitionProduct) {
		getRequisitionProducts().remove(requisitionProduct);
		requisitionProduct.setProduct(null);

		return requisitionProduct;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setProduct(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setProduct(null);

		return stock;
	}

}