package com.jinanging.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jinanging.spring.test.mvc.domain.Realtor;
import com.jinanging.spring.test.mvc.service.RealtorService;

@Controller
@RequestMapping("/mvc")
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	@GetMapping("/realtor/create")
	public String createRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address")String address
			, @RequestParam("grade")String grade
			,Model model){
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		realtor.setPhoneNumber(phoneNumber);
		
		int count  = realtorService.addRealtor(realtor);
		
		model.addAttribute("realtor",realtor);
		
		return "mvc/RealtorInfo";
	}
	
	@GetMapping("/input")
	public String realtorInput() {
		return "mvc/RealtorInput";
	}
	
	
	
	
	

}
