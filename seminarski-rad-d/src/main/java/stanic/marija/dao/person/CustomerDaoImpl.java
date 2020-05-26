package stanic.marija.dao.person;
import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {


}
