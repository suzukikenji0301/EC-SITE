package jp.co.example.ecommerce_a.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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
	 * @return 一覧画面にリダイレクト
	 */
	@PostMapping("/insertC")
	public String insertContact(@Validated InsertContactForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return toInsertContact(form);
		}
		Contact contact = new Contact();
		BeanUtils.copyProperties(form, contact);
		insertcontactService.insertContact(contact);
//		contact.setGender(form.getGender());
		System.out.println("送信された");
		return "redirect:/item_list";
	}
	

}