package stanic.marija.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stanic.marija.dao.person.RoleDao;
import stanic.marija.model.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}

	@Override
	public Role findById(int id) {
		return roleDao.findById(id);
	}

	@Override
	public Role findByType(String type) {
		return roleDao.findByType(type);
	}

}
