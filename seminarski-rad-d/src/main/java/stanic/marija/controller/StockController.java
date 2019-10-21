package stanic.marija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stanic.marija.model.SalesUnit;
import stanic.marija.model.Stock;
import stanic.marija.service.SalesUnitService;
import stanic.marija.service.StockService;

@Controller
public class StockController {

	@Autowired
	StockService stockService;
	@Autowired
	SalesUnitService salesUnitService;

	@RequestMapping(value = "/sales-unit/{id}/stock", method = RequestMethod.GET)
	public ResponseEntity<List<Stock>> getStocksForSalesUnit(@PathVariable("id") int id) {
		List<Stock> stocks = stockService.getStocksForSalesUnit(id);
		return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
	}

	@RequestMapping(value = "/stock", method = RequestMethod.POST)
	public ResponseEntity<Void> createStock(@RequestBody Stock stock) {
		stockService.saveStock(stock);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public ResponseEntity<List<Stock>> getStocks(){
		List<Stock> stocks = stockService.getStocks();
		if (stocks.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sales-unit/{id}/stock", method = RequestMethod.POST)
	public ResponseEntity<Void> createStockForSalesUnit(@PathVariable("id") int id, @RequestBody Stock stock) {
		SalesUnit salesUnit = salesUnitService.findById(id);
		stock.setSalesUnit(salesUnit);
		stockService.saveStock(stock);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/stock", method = RequestMethod.PUT)
	public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
		Stock updatedStock = stockService.updateStock(stock);
		return new ResponseEntity<Stock>(updatedStock, HttpStatus.OK);
	}

	@RequestMapping(value = "/stock{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Stock> deleteStock(@PathVariable("id") int id) {
		stockService.deleteStockById(id);
		return new ResponseEntity<Stock>(HttpStatus.NO_CONTENT);
	}
}
