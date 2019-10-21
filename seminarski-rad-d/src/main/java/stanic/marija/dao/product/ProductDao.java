package stanic.marija.dao.product;

import java.util.List;

import stanic.marija.dao.GenericDao;
import stanic.marija.model.Product;

public interface ProductDao extends GenericDao<Integer, Product>{

	List<Product> getProducts();

	Product findById(int id);

}
