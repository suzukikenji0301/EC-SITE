package jp.co.example.ecommerce_a.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.domain.Contact;
import jp.co.example.ecommerce_a.form.InsertContactForm;
import jp.co.example.ecommerce_a.service.InsertContactService;

@Controller
@RequestMapping("/contact")
public class InsertContactController {

	@Autowired
	private InsertContactService insertcontactService;

	/**
	 * お問合せフォーム画面出力.
	 * 
	 * @param form お問合せフォーム
	 * @return お問合せフォーム画面
	 */
	@RequestMapping("/InsertContact")
	public String toInsertContact(InsertContactForm form) {
		return "contactForm";
	}

	/**
	 * お問合せ情報を登録します.
	 * 
	 * @param form お問い合わせフォーム
	 * @return ログイン画面にリダイレクト
	 */
	@RequestMapping("/insertC")
	public String insertContact(@Validated InsertContactForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/";
		}
	
		Contact contact = new Contact();
		BeanUtils.copyProperties(form, contact);
		contact.setName(form.getName() + form.getName());
		insertcontactService.insertContact(contact);
		return "redirect:/";
	}

}