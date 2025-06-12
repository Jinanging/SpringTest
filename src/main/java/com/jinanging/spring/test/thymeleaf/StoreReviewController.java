package com.jinanging.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jinanging.spring.test.thymeleaf.domain.StoreReview;
import com.jinanging.spring.test.thymeleaf.service.StoreReviewService;

@Controller
public class StoreReviewController {
	
	@Autowired
	StoreReviewService storeService;
	
	
	@GetMapping("thymeleaf/storeInfo")
	public String storeInfo(Model model) {
		List<StoreReview> store = storeService.getStore();
		model.addAttribute("storeList",store);
		
		return "thymeleaf/store/store";
		
		
		
		
		
	}


}
