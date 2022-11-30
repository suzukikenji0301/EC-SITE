package jp.co.example.ecommerce_a.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.domain.User;
import jp.co.example.ecommerce_a.form.InsertUserForm;
import jp.co.example.ecommerce_a.service.InsertUserService;

/**
 * @author kenji.suzuki
 *
 */
@Controller
@RequestMapping("/insertUser")
public class InsertUserController {
	
	@Autowired
	private InsertUserService insertUserService;
	
	/**
	 * 	ユーザー登録画面を出力
	 * 
	 * @return ユーザー登録画面
	 */
	@RequestMapping("/toInsert")
	public String toResisterAdmin(InsertUserForm form) {
		return "register_admin";
	}
	
	/**
	 * ユーザー情報を登録します.
	 * 
	 * @param form ユーザー登録用フォーム
	 * @return　ログイン画面にリダイレクト
	 */
	@RequestMapping("/insert")
	public String insertUser(@Validated InsertUserForm form,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return toResisterAdmin(form);
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		user.setName(form.getLastName() + form.getFirstName());
		insertUserService.insertUser(user);
		return "redirect:/";
	}
}
