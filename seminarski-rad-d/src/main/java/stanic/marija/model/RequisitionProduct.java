package stanic.marija.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the requisition_product database table.
 * 
 */
@Entity
@Table(name="requisition_product")
@NamedQuery(name="RequisitionProduct.findAll", query="SELECT r FROM RequisitionProduct r")
public class RequisitionProduct implements Serializable {
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

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to Requisition
	@ManyToOne
	private Requisition requisition;

	public RequisitionProduct() {
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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Requisition getRequisition() {
		return this.requisition;
	}

	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}

}