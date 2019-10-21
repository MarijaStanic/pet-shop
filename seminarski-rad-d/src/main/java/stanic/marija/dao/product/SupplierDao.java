package stanic.marija.dao.product;

import java.util.List;

import stanic.marija.dao.GenericDao;
import stanic.marija.model.Supplier;

public interface SupplierDao extends GenericDao<Integer, Supplier>{

	List<Supplier> getSuppliers();

	Supplier findById(int id);

}
