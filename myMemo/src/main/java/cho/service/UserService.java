package cho.service;

import cho.entity.User;
import cho.form.UserForm;

public interface UserService {
	
	public void save(UserForm userForm);
	
	public boolean login(UserForm userForm);
	
	public String getUserName(UserForm userForm);
	
	public User findByUserMail(UserForm userForm);
	
	public User findByUserId(Integer userId);
	

}
