package stanic.marija.dao.person;

import java.util.List;

import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoles() {
		return getEntityManager().createQuery("SELECT r FROM Role r ORDER BY r.type ASC").getResultList();
	}

	@Override
	public Role findByType(String type) {
		return (Role) getEntityManager().createQuery("SELECT r FROM Role r WHERE r.type=" + type).getSingleResult();
	}

	@Override
	public Role findById(int id) {
		return getByKey(id);
	}

}
