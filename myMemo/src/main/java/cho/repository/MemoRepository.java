package cho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cho.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo,Integer> {
	
	public List<Memo> findByMemoId(Integer memoId);
	public List<Memo> findAllByOrderByMemoIdDesc();
	
}
