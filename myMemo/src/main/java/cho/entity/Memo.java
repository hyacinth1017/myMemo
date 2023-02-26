package cho.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table

public class Memo {
	
	
	
	@Id
	@Column(name = "memo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memoId;
	
	@Column(name = "memo_title")
	private String memoTitle;
	
	@Column(name = "memo_text")
	private String memoText;
	
	@Column(name = "memo_time")
	private String memoTime;

}
