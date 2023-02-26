package cho.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cho.entity.User;
import cho.form.UserForm;
import cho.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	
	public void save(UserForm userForm) {
		User user = new User();
		user.setUserMail(userForm.getUserMail());
		user.setUserName(userForm.getUserName());
		user.setUserPassword(userForm.getUserPassword());
		userRepository.save(user);
		
	}


	
	public boolean login(UserForm userForm) {
		String userMail = userForm.getUserMail();
		String userPassword = userForm.getUserPassword();	
		List<User> users = new ArrayList<User>();
	    users = userRepository.findByUserMail(userMail);	
		User user  = users.get(0);		
		String getUserPassword = user.getUserPassword();		
		return getUserPassword.equals(userPassword);
		
			
	}
	
	public String getUserName(UserForm userForm) {		
			String userMail = userForm.getUserMail();
			List<User> users = new ArrayList<User>();
		    users = userRepository.findByUserMail(userMail);
			User user  = users.get(0);
			return user.getUserName();
			
	}
	
	public User findByUserMail(UserForm userForm) {
		
		String userMail = userForm.getUserMail();
		List<User> users = new ArrayList<User>();
	    users = userRepository.findByUserMail(userMail);
		User user  = users.get(0);
		return user;
		
	}
	
	public User findByUserId(Integer userId) {
		List<User> users  = userRepository.findByUserId(userId);
		User user = users.get(0);
		return user;
		
	}
	
	
	
	

}
