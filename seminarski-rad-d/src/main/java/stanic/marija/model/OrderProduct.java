package stanic.marija.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderr_product database table.
 * 
 */
@Entity
@Table(name="orderr_product")
@NamedQuery(name="OrderProduct.findAll", query="SELECT o FROM OrderProduct o")
public class OrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order orderr;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	private Stock stock;

	public OrderProduct() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrderr() {
		return this.orderr;
	}

	public void setOrderr(Order orderr) {
		this.orderr = orderr;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}