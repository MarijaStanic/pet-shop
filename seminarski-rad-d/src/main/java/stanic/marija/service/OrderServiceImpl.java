package stanic.marija.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stanic.marija.dao.order.OrderDao;
import stanic.marija.model.Order;
import stanic.marija.model.OrderProduct;
import stanic.marija.model.Stock;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	@Autowired
	StockService stockService;

	@Override
	public List<Order> getOrders() {
		return orderDao.findAll();
	}

	@Override
	public void saveOrder(Order order, Map<String, Integer> orderProducts) {
		for (Map.Entry<String, Integer> entry : orderProducts.entrySet()) {
			OrderProduct op = new OrderProduct();
			Stock stock = stockService.findById(Integer.parseInt(entry.getKey()));
			int orderedQuantity = entry.getValue();
			stock.setQuantity(stock.getQuantity() - orderedQuantity);
			op.setStock(stock);
			op.setQuantity(orderedQuantity);
			order.addOrderrProduct(op);
		}
		orderDao.persist(order);
	}

}
