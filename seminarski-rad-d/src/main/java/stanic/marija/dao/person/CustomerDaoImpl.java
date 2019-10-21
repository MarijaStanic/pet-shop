package stanic.marija.dao.person;
import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		return getEntityManager().createQuery("SELECT c FROM Customer c ORDER BY c.firstName ASC").getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		persist(customer);
		
	}

	@Override
	public Customer findById(int id) {
		Customer customer = getByKey(id);
		return customer;
	}

}
