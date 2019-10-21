package stanic.marija.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stanic.marija.dao.salesUnit.StockDao;
import stanic.marija.model.Stock;

@Service("stockService")
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	StockDao stockDao;

	@Override
	public List<Stock> getStocksForSalesUnit(int id) {
		return stockDao.getStocksForSalesUnit(id);
	}

	@Override
	public void saveStock(Stock stock) {
		stockDao.persist(stock);

	}

	@Override
	public Stock updateStock(Stock stock) {
		Stock entity = stockDao.getByKey(stock.getId());
		if (entity != null) {
			entity.setQuantity(stock.getQuantity());
			entity.setSalesUnit(stock.getSalesUnit());
			entity.setProduct(stock.getProduct());
		}
		return entity;
	}

	@Override
	public void deleteStockById(int id) {
		Stock stock = stockDao.getByKey(id);
		stockDao.delete(stock);
	}

	@Override
	public List<Stock> getStocks() {
		return stockDao.getStocks();
	}

	@Override
	public Stock findById(int id) {
		return stockDao.getByKey(id);
	}

}
