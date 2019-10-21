package stanic.marija.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the sales_unit database table.
 * 
 */
@Entity
@Table(name = "sales_unit")
@NamedQuery(name = "SalesUnit.findAll", query = "SELECT s FROM SalesUnit s")
public class SalesUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int status_notActive = 0;
	public static final int status_active = 1;

	public String getStatusValue() {
		switch (this.status) {
		case status_notActive:
			return "Not Active";
		case status_active:
			return "Active";
		default:
			return "Invalid Status";
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String address;

	private String email;

	private String name;

	private String phone;

	private int status;

	@JsonIgnore
	// bi-directional many-to-one association to Stock
	@Cascade(CascadeType.REMOVE)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "salesUnit")
	private List<Stock> stocks;

	// bi-directional many-to-one association to User
	// @LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy = "salesUnit")

	private List<User> users;

	public SalesUnit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setSalesUnit(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setSalesUnit(null);

		return stock;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setSalesUnit(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setSalesUnit(null);

		return user;
	}

}