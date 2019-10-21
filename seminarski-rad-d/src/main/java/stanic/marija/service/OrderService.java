package stanic.marija.service;

import java.util.List;
import java.util.Map;

import stanic.marija.model.Order;

public interface OrderService {

	List<Order> getOrders();

	void saveOrder(Order order, Map<String, Integer> orderProducts);

}
