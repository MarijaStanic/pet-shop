package stanic.marija.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stanic.marija.dao.product.SupplierDao;
import stanic.marija.model.Supplier;

@Service("supplierService")
@Transactional
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	SupplierDao supplierDao;

	@Override
	public List<Supplier> getSuppliers() {
		return supplierDao.getSuppliers();
	}

	@Override
	public void saveSupplier(Supplier supplier) {
		supplierDao.persist(supplier);
		
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		Supplier entity = supplierDao.findById(supplier.getId());
		if (entity != null) {
			entity.setFirstName(supplier.getFirstName());
			entity.setLastName(supplier.getLastName());
			entity.setAddress(supplier.getAddress());
			entity.setEmail(supplier.getEmail());
			entity.setHomePhone(supplier.getHomePhone());
			entity.setMobilePhone(supplier.getMobilePhone());
		}
		return entity;
	}

	@Override
	public void deleteSupplierById(Integer id) {
		Supplier supplier = supplierDao.getByKey(id);
		supplierDao.delete(supplier);
		
	}
}
