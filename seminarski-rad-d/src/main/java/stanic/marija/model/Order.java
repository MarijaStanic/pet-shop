package stanic.marija.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orderr database table.
 * 
 */
@Entity
@Table(name="orderr")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="order_created")
	private Date orderCreated;

	@Temporal(TemporalType.DATE)
	@Column(name="order_delivered")
	private Date orderDelivered;

	private int quantity;

	@Column(name="total_price")
	private double totalPrice;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer customer;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="orderr")
	private List<OrderProduct> orderrProducts = new ArrayList<>();

	public Order() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrderCreated() {
		return this.orderCreated;
	}

	public void setOrderCreated(Date orderCreated) {
		this.orderCreated = orderCreated;
	}

	public Date getOrderDelivered() {
		return this.orderDelivered;
	}

	public void setOrderDelivered(Date orderDelivered) {
		this.orderDelivered = orderDelivered;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderProduct> getOrderrProducts() {
		return this.orderrProducts;
	}

	public void setOrderrProducts(List<OrderProduct> orderrProducts) {
		this.orderrProducts = orderrProducts;
	}

	public OrderProduct addOrderrProduct(OrderProduct orderrProduct) {
		getOrderrProducts().add(orderrProduct);
		orderrProduct.setOrderr(this);

		return orderrProduct;
	}

	public OrderProduct removeOrderrProduct(OrderProduct orderrProduct) {
		getOrderrProducts().remove(orderrProduct);
		orderrProduct.setOrderr(null);

		return orderrProduct;
	}

}