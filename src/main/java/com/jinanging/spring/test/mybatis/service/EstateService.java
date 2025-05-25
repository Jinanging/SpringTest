package com.jinanging.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinanging.spring.test.mybatis.domain.Estate;
import com.jinanging.spring.test.mybatis.repository.EstateRepository;

@Service
public class EstateService {
	
	@Autowired
	private EstateRepository estateRepository;
	
	public Estate getEstate(int id) {
		
		Estate estate = estateRepository.selectEstate(id);
		
		return estate;
		
	}
	
	public List<Estate> getOptionEstate(int rentPrice){
		
		List<Estate> optionEstate = estateRepository.optionEstate(rentPrice);
		
		return optionEstate;
		
	}
	
	public List<Estate> getRealEstateAreaAndPrice(int area, int price){
		List<Estate> realEstateList = estateRepository.selectRealEstateByAreaAndPrice(area, price);
		return realEstateList;
		
	}
	
	public int addRealEstateByObject(Estate estate) {
		int count = estateRepository.insertRealEstateByObject(estate);
		return count;
	}
	
	public int addRealEstate(
				int realtorId
				, String address
				, int area
				, String type
				, int price
				, int rentPrice) {
		int count = estateRepository.insertRealEstate(realtorId,address,area,type,price,rentPrice);
		return count;
	}
	
	public int updateRealEstate(int id, String type, int price) {
		int count = estateRepository.updateRealEstate(id,type,price);
		return count;
	}
	
	public int deleteRealEstate(int id) {
		int count = estateRepository.deleteRealEstate(id);
		return count;
	}
	

}
