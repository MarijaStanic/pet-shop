package stanic.marija.service;

import java.util.List;

import stanic.marija.model.Stock;

public interface StockService {

	List<Stock> getStocksForSalesUnit(int id);

	void saveStock(Stock stock);

	Stock updateStock(Stock stock);

	void deleteStockById(int id);

	List<Stock> getStocks();
	
	Stock findById(int id);
}
