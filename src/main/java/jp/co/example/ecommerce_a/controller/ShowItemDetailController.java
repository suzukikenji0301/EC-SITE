package jp.co.example.ecommerce_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.ecommerce_a.domain.Item;
import jp.co.example.ecommerce_a.form.InsertCartForm;
import jp.co.example.ecommerce_a.service.ShowItemDetailService;

/**
 * 商品詳細を表示するControllerクラス.
 * 
 * @author kumagaimayu
 *
 */
@Controller
@RequestMapping("/showItemDetail")
public class ShowItemDetailController {

	@Autowired
	private ShowItemDetailService showItemDetailService;

	@GetMapping("/showItemDetail")
	public String showItemDetail(Integer id, Model model,InsertCartForm insertCartForm) {
		Item item = showItemDetailService.showItemDetail(id);
		model.addAttribute("item", item);
		return "item_detail";
	}

}
