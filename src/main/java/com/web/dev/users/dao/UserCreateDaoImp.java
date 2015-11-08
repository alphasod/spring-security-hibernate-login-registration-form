package com.web.dev.users.dao;
import com.web.dev.users.model.User;
import com.web.dev.users.model.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
public class UserCreateDaoImp implements UserCreateDao {

public SessionFactory sessionFactory;
@SuppressWarnings("unchecked")
  public User createUser(User user) {
 sessionFactory.getCurrentSession().save(user);
    UserRole userRole=new UserRole(user,"ROLE_USER");
    sessionFactory.getCurrentSession().save(userRole);
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String hashedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(hashedPassword);
    return null;
 }
 
public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
         /** 
 * {@inheritDoc}
 */
}
