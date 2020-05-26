package stanic.marija.service;

import java.util.List;

import stanic.marija.model.Stock;

public interface StockService {

	List<Stock> getStocksForSalesUnit(Integer id);

	void saveStock(Stock stock);

	Stock updateStock(Stock stock);

	void deleteStockById(Integer id);

	List<Stock> getStocks();
	
	Stock findById(Integer id);
}
