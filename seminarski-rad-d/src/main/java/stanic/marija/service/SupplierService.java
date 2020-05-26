package stanic.marija.service;

import java.util.List;

import stanic.marija.model.Supplier;

public interface SupplierService {

	List<Supplier> getSuppliers();

	void saveSupplier(Supplier supplier);

	Supplier updateSupplier(Supplier supplier);

	void deleteSupplierById(Integer id);

}
