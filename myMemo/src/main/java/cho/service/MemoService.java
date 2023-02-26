package cho.service;

import cho.entity.Memo;
import cho.form.PostForm;

public interface MemoService {
	
	public Memo findByMemoId(Integer memoId);
	
	public void updateMemo(PostForm postForm);
}
