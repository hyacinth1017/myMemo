package cho.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cho.entity.Memo;
import cho.entity.MemoComparator;
import cho.entity.User;
import cho.form.PostForm;
import cho.form.UserForm;
import cho.service.MemoService;
import cho.service.PostService;
import cho.service.UserService;

@Controller
public class MyMemoController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	MemoService memoService;
	
	
	
	//TopPageを表示する
	@GetMapping("/")
	public String index() {
		return"index";
	}
	
	//新規登録ページを表示する
	@GetMapping("regist")
	public  String regist() {
		return "regist";
	}
	
	//ユーザー新規登録
	@PostMapping("userRegist")
	public String userRegist(UserForm userForm, Model model)	{
		
		userService.save(userForm);
		model.addAttribute("userName", userService.getUserName(userForm));
		return"registOk";
	}
	
	
	//ユーザーログイン成功したら、loginOkページに遷移
	@PostMapping("login")
	public String login( UserForm userForm,Model model) {
		

		if(userService.login(userForm)) {
			
			User user = userService.findByUserMail(userForm);
			model.addAttribute("user",user);
			return "loginOk" ;	
		}
		model.addAttribute("message","メールアドレスまたはパスワードに間違いがあります。");
		return"index";
		
		
		
	}
	
	
	//loginOkページからMyPageに遷移
	@GetMapping("/login/{userId}")
	public String myPage(@PathVariable("userId") Integer userId, Model model) {
		User user = userService.findByUserId(userId);
		model.addAttribute("user",user);
		
		
			 
		List<Memo> memoList =  postService.findByUserId(userId);
			
		//MemoIdでソートする
        MemoComparator cmp = new MemoComparator();
        memoList.sort(cmp);
	    model.addAttribute("memoList" , memoList);
		return"myPage";
	}
	
	
	//Memoを提出して、最新のMyPageに遷移
		@PostMapping("login/postMemo")
		public String postMemo(PostForm postForm, Model model) {
			postService.save(postForm);
			
			User user = new User();
			user.setUserName(postForm.getUserName());
			user.setUserId(postForm.getUserId());
			
			model.addAttribute("user",user);
	
			return "redirect:/login/" + user.getUserId();
		}
	
	
		//Memoを削除して、最新のMyPageに遷移
		@GetMapping("login/{userId}/delete/{memoId}")
		public String deleteMemo(@PathVariable("memoId") Integer memoId,
		                         @PathVariable("userId") Integer userId,Model model) {
			
			
			postService.deleteMemo(memoId);
			
			User user = userService.findByUserId(userId);
			model.addAttribute("user",user);
			
			return "redirect:/login/" + user.getUserId();
		}
		
		
		//Memo更新ページを表示する
		@GetMapping("login/{userId}/update/{memoId}")
		public String updatePage(@PathVariable("userId") Integer userId,
				                 @PathVariable("memoId") Integer memoId, Model model) {
			
			User user = userService.findByUserId(userId);
			model.addAttribute("user",user);
			
			Memo memo = memoService.findByMemoId(memoId);
			model.addAttribute("memo", memo);		
			
      		return "update";
      		
		}
		
		//Memoを更新して、最新のMyPageに遷移
		@PostMapping("login/update")
		public String updateMemo(PostForm postForm,  Model model) {
			
            memoService.updateMemo(postForm);
            
            User user = userService.findByUserId(postForm.getUserId());
			model.addAttribute("user",user);
			
			return "redirect:/login/" + user.getUserId();
			
		}
		
		
	
	
	
	
	
	
	
	

	
	

}
