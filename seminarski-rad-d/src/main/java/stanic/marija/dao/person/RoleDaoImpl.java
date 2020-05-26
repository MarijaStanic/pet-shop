package stanic.marija.dao.person;

import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

	@Override
	public Role findByType(String type) {
		return (Role) getEntityManager().createQuery("FROM Role r WHERE r.type=" + type).getSingleResult();
	}

}
