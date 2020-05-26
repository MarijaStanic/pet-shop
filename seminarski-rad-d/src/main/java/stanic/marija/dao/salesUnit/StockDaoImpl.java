package stanic.marija.dao.salesUnit;

import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.Stock;

@Repository("stockDao")
public class StockDaoImpl extends AbstractDao<Integer, Stock> implements StockDao {

	@Override
	public List<Stock> getStocksForSalesUnit(int id) {
		@SuppressWarnings("unchecked")
		List<Stock> stocks = (List<Stock>) getEntityManager()
				.createQuery("SELECT s FROM Stock s WHERE s.salesUnit.id=" + id).getResultList();
		return stocks;
	}

}
