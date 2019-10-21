package stanic.marija.dao.person;

import java.util.List;

import stanic.marija.dao.GenericDao;
import stanic.marija.model.Customer;

public interface CustomerDao extends GenericDao<Integer, Customer>{

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer findById(int id);
}
