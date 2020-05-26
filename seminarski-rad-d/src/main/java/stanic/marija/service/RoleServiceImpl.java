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
		return roleDao.findAll();
	}

	@Override
	public Role findById(Integer id) {
		return roleDao.getByKey(id);
	}

	@Override
	public Role findByType(String type) {
		return roleDao.findByType(type);
	}

}
