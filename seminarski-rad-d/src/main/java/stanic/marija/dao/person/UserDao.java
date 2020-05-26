package stanic.marija.dao.person;

import java.util.List;

import stanic.marija.dao.GenericDao;
import stanic.marija.model.User;

public interface UserDao extends GenericDao<Integer, User> {
    
    void deleteUserByUsername(String username);

	User findByUsername(String username);
	
	List<User> findAllWithRoles();
	
	User getByIdWithRoles(Integer id);
	
}
