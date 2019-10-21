package stanic.marija.dao.person;

import java.util.List;

import stanic.marija.dao.GenericDao;
import stanic.marija.model.User;

public interface UserDao extends GenericDao<Integer, User> {
	
	void saveUser(User user);
    
    void deleteUserByUsername(String username);

	User findById(int id);
	
	User findByUsername(String username);
     
    List<User> getAllUsers();
}
