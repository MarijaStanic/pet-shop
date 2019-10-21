package stanic.marija.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int quantity;

	@JsonIgnore
	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="stock")
	private List<OrderProduct> orderProducts;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to SalesUnit
	@ManyToOne
	@JoinColumn(name="sales_unit_id")
	private SalesUnit salesUnit;

	public Stock() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderProduct> getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderrProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public OrderProduct addOrderProduct(OrderProduct orderrProduct) {
		getOrderProducts().add(orderrProduct);
		orderrProduct.setStock(this);

		return orderrProduct;
	}

	public OrderProduct removeOrderrProduct(OrderProduct orderProduct) {
		getOrderProducts().remove(orderProduct);
		orderProduct.setStock(null);

		return orderProduct;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SalesUnit getSalesUnit() {
		return this.salesUnit;
	}

	public void setSalesUnit(SalesUnit salesUnit) {
		this.salesUnit = salesUnit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}