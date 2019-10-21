package stanic.marija.dao.order;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.Order;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrders() {
		List<Order> orders = getEntityManager().createQuery("SELECT o FROM Order o").getResultList();
		for(Order o: orders){
			Hibernate.initialize(o.getOrderrProducts());
		}
		return orders;
	}

}
