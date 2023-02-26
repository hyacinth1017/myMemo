package cho.service;

import java.util.List;

import cho.entity.Memo;
import cho.form.PostForm;

public interface PostService {
	public void save(PostForm postForm);
	
	public List<Memo> findByUserId(Integer userId);
	
	public void deleteMemo(Integer memoId);
	
	

	
}
