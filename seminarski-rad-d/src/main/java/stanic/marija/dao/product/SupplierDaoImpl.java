package stanic.marija.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.Supplier;

@Repository("supplierDao")
public class SupplierDaoImpl extends AbstractDao<Integer, Supplier> implements SupplierDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getSuppliers() {
		return getEntityManager().createQuery("SELECT s FROM Supplier s ORDER BY s.firstName ASC").getResultList();
		
	}

	@Override
	public Supplier findById(int id) {
		return getByKey(id);
	}

}
