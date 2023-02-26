package cho.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cho.entity.Memo;
import cho.entity.Post;
import cho.form.PostForm;
import cho.repository.MemoRepository;
import cho.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	MemoRepository memoRepository;
	
	
	

	
	public void save(PostForm postForm) {
		
		Memo memo = new Memo();
		memo.setMemoTitle(postForm.getMemoTitle());
		memo.setMemoText(postForm.getMemoText());
		
		//Memoの作成時間
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String time = simpleDateFormat1.format(timestamp);
        memo.setMemoTime(time);
        
		
		memoRepository.save(memo);
		
		Post post = new Post();
		post.setUserId(postForm.getUserId());
		post.setMemoId(memo.getMemoId());
		postRepository.save(post);	
		
	}
	

	
	public List<Memo> findByUserId(Integer userId){
		
		List<Integer> ids = new ArrayList<Integer>();
		
		List<Post> postList = postRepository.findByUserId(userId);
		for(Post post : postList) {
			ids.add(post.getMemoId());
			
		}
		List<Memo> memoList =memoRepository.findAllById(ids);
		
		
		
		
		return memoList;
		
		
	}
	
	public void deleteMemo(Integer memoId) {
		List<Post> postList = postRepository.findByMemoId(memoId);
		postRepository.delete(postList.get(0));
		
		List<Memo> memoList = memoRepository.findByMemoId(memoId);
		memoRepository.delete(memoList.get(0));
	}
	
	
	
	
	
	
	
	

}
