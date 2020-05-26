package stanic.marija.service;

import java.util.List;

import stanic.marija.model.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer findById(Integer id);

	void deleteCustomerById(Integer id);
}
