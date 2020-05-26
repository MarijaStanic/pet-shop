package stanic.marija.dao.person;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import stanic.marija.dao.AbstractDao;
import stanic.marija.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User getByIdWithRoles(Integer id) {
		User user = getByKey(id);
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	public List<User> findAllWithRoles() {
		List<User> users = getEntityManager().createQuery("FROM User u ORDER BY u.firstName ASC")
				.getResultList();
		for (User user : users) {
			Hibernate.initialize(user.getRoles());
		}
		return users;
	}

	@Override
	public void deleteUserByUsername(String username) {
		User user = (User) getEntityManager().createQuery("FROM User u WHERE u.username LIKE :username")
				.setParameter("username", username).getSingleResult();
		delete(user);
	}

	@Override
	public User findByUsername(String username) {
		try {
			User user = (User) getEntityManager().createQuery("FROM User u WHERE u.username LIKE :username")
					.setParameter("username", username).getSingleResult();
			if (user != null) {
				Hibernate.initialize(user.getRoles());
			}
			return user;
		} catch (NoResultException ex) {
			return null;
		}
	}
}