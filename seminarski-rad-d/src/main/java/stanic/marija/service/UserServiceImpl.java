package stanic.marija.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import stanic.marija.dao.person.UserDao;
import stanic.marija.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.persist(user);	
	}

	@Override
	public User findById(Integer id) {
		return dao.getByKey(id);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public User updateUser(User user) {
		User entity = dao.getByKey(user.getId());
        if(entity!=null){
        	entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setAddress(user.getAddress());
            entity.setEmail(user.getEmail());
            entity.setUsername(user.getUsername());
            entity.setSalesUnit(user.getSalesUnit());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setRoles(user.getRoles());
            dao.update(entity);
        }
        return entity;
	}

	@Override
	public boolean isUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public void deleteUserByUsername(String username) {
		dao.deleteUserByUsername(username);
		
	}

	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public boolean doesUserExist(User user) {
	       return findByUsername(user.getUsername())!=null;
	}

	@Override
	public void deleteUserById(Integer id) {
		User entity = findById(id);
		dao.delete(entity);
	}
}
