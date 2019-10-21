package stanic.marija.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		return getEntityManager().createQuery("SELECT p FROM Product p ORDER BY p.name ASC").getResultList();
	}

	@Override
	public Product findById(int id) {
		return getByKey(id);
	}

}
