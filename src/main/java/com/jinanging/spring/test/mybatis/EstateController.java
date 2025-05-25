package com.jinanging.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinanging.spring.test.mybatis.domain.Estate;
import com.jinanging.spring.test.mybatis.service.EstateService;

@Controller
@RequestMapping("/mybatis/real-estate")
public class EstateController {
	
	// id로 select해서 값 가져오기 
	
	@Autowired
	private EstateService estateService;
	
	@RequestMapping("/select/1")
	@ResponseBody
	public Estate estate(@RequestParam("id") int id) {
		
		Estate estate = estateService.getEstate(id);
		return estate;
		
	}
	
	@RequestMapping("/select/2")
	@ResponseBody
	public List<Estate> optionestate(@RequestParam("rentPrice") int rentPrice) {
		
		List<Estate> optionEstate = estateService.getOptionEstate(rentPrice);
		return optionEstate;
		
	}
	
	@ResponseBody
	@RequestMapping("/3")
	public List<Estate> realEstateByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		List<Estate> realEstateList = estateService.getRealEstateAreaAndPrice(area, price);
		
		return realEstateList;
	}
	
	@ResponseBody
	@RequestMapping("/insert/1")
	public String createRealEstateByObject() {
		
//		realtorId : 3
//		address : 푸르지용 리버 303동 1104호
//		area : 89
//		type : 매매
//		price : 100000
		
		Estate realEstate = new Estate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = estateService.addRealEstateByObject(realEstate);
		
		// 실행 결과 : 1
		
		return "실행 결과 : " + count;
	}
	
	@ResponseBody
	@RequestMapping("/insert/2")
	public String createRealEstate(@RequestParam("realtorId") int realtorId) {
//		address : 썅떼빌리버 오피스텔 814호
//		area : 45
//		type : 월세
//		price : 100000
//		rentPrice : 120
		int count = estateService.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		
		return "실행 결과 : " + count;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String updateRealEstate() {
//		id가 22 인 행의 type 을 전세로 바꾸고 price 를 70000으로 변경하세요.
		int count = estateService.updateRealEstate(22, "전세", 70000);
		
		return "실행 결과 : " + count;
		
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteRealEstate(@RequestParam("id") int id) {
		
		int count = estateService.deleteRealEstate(id);
		
		return "실행 결과 : " + count;
	}
	
	

}
