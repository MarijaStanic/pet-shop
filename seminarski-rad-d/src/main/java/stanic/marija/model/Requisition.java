package stanic.marija.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the requisition database table.
 * 
 */
@Entity
@NamedQuery(name="Requisition.findAll", query="SELECT r FROM Requisition r")
public class Requisition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="requisition_created")
	private Date requisitionCreated;

	@Temporal(TemporalType.DATE)
	@Column(name="requisition_delivered")
	private Date requisitionDelivered;

	@Column(name="total_supplier_price")
	private double totalSupplierPrice;

	private double weight;

	//bi-directional many-to-one association to RequisitionProduct
	@OneToMany(mappedBy="requisition")
	private List<RequisitionProduct> requisitionProducts;

	public Requisition() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRequisitionCreated() {
		return this.requisitionCreated;
	}

	public void setRequisitionCreated(Date requisitionCreated) {
		this.requisitionCreated = requisitionCreated;
	}

	public Date getRequisitionDelivered() {
		return this.requisitionDelivered;
	}

	public void setRequisitionDelivered(Date requisitionDelivered) {
		this.requisitionDelivered = requisitionDelivered;
	}

	public double getTotalSupplierPrice() {
		return this.totalSupplierPrice;
	}

	public void setTotalSupplierPrice(double totalSupplierPrice) {
		this.totalSupplierPrice = totalSupplierPrice;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<RequisitionProduct> getRequisitionProducts() {
		return this.requisitionProducts;
	}

	public void setRequisitionProducts(List<RequisitionProduct> requisitionProducts) {
		this.requisitionProducts = requisitionProducts;
	}

	public RequisitionProduct addRequisitionProduct(RequisitionProduct requisitionProduct) {
		getRequisitionProducts().add(requisitionProduct);
		requisitionProduct.setRequisition(this);

		return requisitionProduct;
	}

	public RequisitionProduct removeRequisitionProduct(RequisitionProduct requisitionProduct) {
		getRequisitionProducts().remove(requisitionProduct);
		requisitionProduct.setRequisition(null);

		return requisitionProduct;
	}

}