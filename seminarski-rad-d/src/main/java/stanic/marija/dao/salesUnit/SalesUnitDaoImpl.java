package stanic.marija.dao.salesUnit;

import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.SalesUnit;

@Repository("salesUnitDao")
public class SalesUnitDaoImpl extends AbstractDao<Integer, SalesUnit> implements SalesUnitDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SalesUnit> getSalesUnits() {
		return getEntityManager().createQuery("SELECT su FROM SalesUnit su ORDER BY su.name ASC").getResultList();
	}

	@Override
	public void saveSalesUnit(SalesUnit salesUnit) {
		persist(salesUnit);

	}

	@Override
	public SalesUnit findById(int id) {
		SalesUnit su = getByKey(id);
		return su;
	}

}