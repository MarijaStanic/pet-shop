package stanic.marija.dao.salesUnit;

import java.util.List;

import stanic.marija.dao.GenericDao;
import stanic.marija.model.SalesUnit;

public interface SalesUnitDao extends GenericDao<Integer, SalesUnit> {
	
	List<SalesUnit> getSalesUnits();

	void saveSalesUnit(SalesUnit salesUnit);

	SalesUnit findById(int id);

}
