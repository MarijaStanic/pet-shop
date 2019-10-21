package stanic.marija.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import stanic.marija.model.Order;
import stanic.marija.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrders(){
		List<Order> orders = orderService.getOrders();
		if (orders.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<Void> createOrder(@RequestBody String orderToCreate) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(orderToCreate);
		Order order = mapper.convertValue(node.get("order"), Order.class);
		@SuppressWarnings("unchecked")
		Map<String, Integer> map = mapper.convertValue(node.get("orderProducts"), Map.class);
		orderService.saveOrder(order, map);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
}
