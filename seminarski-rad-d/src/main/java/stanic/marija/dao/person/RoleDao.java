package stanic.marija.dao.person;

import java.util.List;

import stanic.marija.dao.GenericDao;
import stanic.marija.model.Role;

public interface RoleDao extends GenericDao<Integer, Role>{
	
	Role findByType(String type);

}
