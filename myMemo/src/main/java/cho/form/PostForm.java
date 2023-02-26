package cho.form;

import lombok.Data;

@Data
public class PostForm {
	
	private Integer postId;
	private Integer userId;
	private String userName;
	private Integer memoId;
	private String memoTitle;
	private String memoText;

}
