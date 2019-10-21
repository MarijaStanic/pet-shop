package stanic.marija.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stanic.marija.dao.person.CustomerDao;
import stanic.marija.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer entity = customerDao.findById(customer.getId());
		if (entity != null) {
			entity.setFirstName(customer.getFirstName());
			entity.setLastName(customer.getLastName());
			entity.setBirthdate(customer.getBirthdate());
			entity.setAddress(customer.getAddress());
			entity.setEmail(customer.getEmail());
			entity.setHomePhone(customer.getHomePhone());
			entity.setMobilePhone(customer.getMobilePhone());
		}
		return entity;
	}

	@Override
	public Customer findById(int id) {
		return customerDao.findById(id);
	}

	@Override
	public void deleteCustomerById(int id) {
		Customer customer = customerDao.findById(id);
		customerDao.delete(customer);

	}

}
