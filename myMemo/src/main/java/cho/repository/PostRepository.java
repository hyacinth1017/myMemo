package cho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cho.entity.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
	
	public List<Post> findByUserId(Integer userId);
	
	public List<Post> findByMemoId(Integer memoId);


}
