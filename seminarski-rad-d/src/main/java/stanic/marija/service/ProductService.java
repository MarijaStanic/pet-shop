package stanic.marija.service;

import java.util.List;

import stanic.marija.model.Product;

public interface ProductService {

	List<Product> getProducts();

	void saveProduct(Product product);

	Product updateProduct(Product product);

	void deleteProductById(Integer id);

}
