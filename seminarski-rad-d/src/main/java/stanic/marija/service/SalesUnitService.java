package stanic.marija.service;

import java.util.List;

import stanic.marija.model.SalesUnit;

public interface SalesUnitService {

	List<SalesUnit> getSalesUnits();

	void saveSalesUnit(SalesUnit salesUnit);

	SalesUnit updateSalesUnit(SalesUnit salesUnit);

	SalesUnit findById(Integer id);

	void deleteSalesUnitById(Integer id);
	
}
