package stanic.marija.service;

import java.util.List;

import stanic.marija.model.User;

public interface UserService {
	
	List<User> getAllUsers();

	void saveUser(User user);
    
	void deleteUserByUsername(String username);

	User findById(Integer id);
	
	User findByUsername(String username);
    
    User updateUser(User user);
    
    boolean isUsernameUnique(Integer id, String username);

	boolean doesUserExist(User user);

	void deleteUserById(Integer id);
}
