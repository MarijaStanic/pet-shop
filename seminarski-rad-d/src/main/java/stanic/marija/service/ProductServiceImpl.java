package stanic.marija.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stanic.marija.dao.product.ProductDao;
import stanic.marija.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getProducts() {
		return productDao.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		productDao.persist(product);

	}

	@Override
	public Product updateProduct(Product product) {
		Product entity = productDao.getByKey(product.getId());
		if (entity != null) {
			entity.setName(product.getName());
			entity.setType(product.getType());
			entity.setPrice(product.getPrice());
			entity.setSize(product.getSize());
			entity.setWeight(product.getWeight());
			entity.setNote(product.getNote());
			entity.setSupplier(product.getSupplier());
		}
		return entity;
	}

	@Override
	public void deleteProductById(Integer id) {
		Product product = productDao.getByKey(id);
		productDao.delete(product);
	}

}
