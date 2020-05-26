package stanic.marija.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stanic.marija.dao.salesUnit.SalesUnitDao;
import stanic.marija.model.SalesUnit;

@Service("salesUnitService")
@Transactional
public class SalesUnitServiceImpl implements SalesUnitService {

	@Autowired
	SalesUnitDao salesUnitDao;

	@Override
	public List<SalesUnit> getSalesUnits() {
		return salesUnitDao.findAll();
	}

	@Override
	public void saveSalesUnit(SalesUnit salesUnit) {
		salesUnitDao.persist(salesUnit);

	}

	@Override
	public SalesUnit updateSalesUnit(SalesUnit salesUnit) {
		SalesUnit entity = salesUnitDao.getByKey(salesUnit.getId());
		if (entity != null) {
			entity.setName(salesUnit.getName());
			entity.setAddress(salesUnit.getAddress());
			entity.setEmail(salesUnit.getEmail());
			entity.setPhone(salesUnit.getPhone());
			entity.setStatus(salesUnit.getStatus());
			entity.setStocks(salesUnit.getStocks());
		}
		return entity;
	}

	@Override
	public SalesUnit findById(Integer id) {
		return salesUnitDao.getByKey(id);
	}

	@Override
	public void deleteSalesUnitById(Integer id) {
		SalesUnit entity = findById(id);
		salesUnitDao.delete(entity);
	}
}
