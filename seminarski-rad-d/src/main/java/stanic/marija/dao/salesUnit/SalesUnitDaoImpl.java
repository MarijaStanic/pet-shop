package stanic.marija.dao.salesUnit;

import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.SalesUnit;

@Repository("salesUnitDao")
public class SalesUnitDaoImpl extends AbstractDao<Integer, SalesUnit> implements SalesUnitDao {


}
