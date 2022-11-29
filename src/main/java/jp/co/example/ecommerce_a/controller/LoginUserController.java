package jp.co.example.ecommerce_a.controller;

//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import jp.co.example.ecommerce_a.domain.User;
import jp.co.example.ecommerce_a.form.LoginUserForm;
//import jp.co.example.ecommerce_a.service.LoginUserService;

/**
 * ユーザー情報を操作するコントローラー.
 * 
 * @author Hirabuki
 *
 */
@Controller
@RequestMapping("/login")
public class LoginUserController {

//	@Autowired
//	private LoginUserService loginUserService;
//
//	@Autowired
//	private HttpSession session;

	@GetMapping("")
	public String toLogin(LoginUserForm form) {
		return "login";
	}

	/**
	 * ログインします.
	 * 
	 * @param form ユーザー情報格納用フォーム
	 * @param model エラー情報格納用
	 * @return　ログインリンクから遷移されていた場合：商品一覧を表示する。ショッピングカート画面から遷移されていた場合：商品一覧を表示する
	 */
//	@PostMapping("/loginUser")
//	public String login(LoginUserForm form, Model model ) {
//		User user = loginUserService.login(form.getEmail(), form.getPassword());
//		if(user == null) {
//			model.addAttribute("loginError", "メールアドレスまたはパスワードが不正です。");
//			return toLogin(form);
//		}
//		session.setAttribute("user", user);
//		if(session.getAttribute("throughOrderConfirmation") == null ) {
//			return "item_list";
//		}
//		session.removeAttribute("throughOrderConfirmation");
//		return "order_confirm";
//	}

}
