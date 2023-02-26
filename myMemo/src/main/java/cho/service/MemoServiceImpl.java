package cho.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cho.entity.Memo;
import cho.form.PostForm;
import cho.repository.MemoRepository;

@Service
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	MemoRepository memoRepository;
	
	public Memo findByMemoId(Integer memoId) {
		List<Memo> memoList = memoRepository.findByMemoId(memoId);
		Memo memo = memoList.get(0);
		return memo;
		
	}
	
		
public void updateMemo(PostForm postForm) {
		
		Integer memoId = postForm.getMemoId();
		List<Memo> memoList = memoRepository.findByMemoId(memoId);
		Memo memo = memoList.get(0);
		memo.setMemoTitle(postForm.getMemoTitle());
		memo.setMemoText(postForm.getMemoText());
		
		//Memoの作成時間
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String time = simpleDateFormat1.format(timestamp);
        memo.setMemoTime(time);
        
		
		memoRepository.save(memo);
		
	
		
	
	}



}
