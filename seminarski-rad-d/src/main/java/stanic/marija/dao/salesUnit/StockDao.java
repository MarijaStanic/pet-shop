package stanic.marija.dao.salesUnit;

import java.util.List;

import stanic.marija.dao.GenericDao;
import stanic.marija.model.Stock;

public interface StockDao extends GenericDao<Integer, Stock> {

	List<Stock> getStocksForSalesUnit(int id);

	List<Stock> getStocks();

}
