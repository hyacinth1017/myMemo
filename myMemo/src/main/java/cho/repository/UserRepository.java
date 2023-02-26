package cho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cho.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	public List<User> findByUserId(Integer userId);
	
	public List<User> findByUserMail(String userMail);
}
