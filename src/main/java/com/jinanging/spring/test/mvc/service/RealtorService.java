package com.jinanging.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinanging.spring.test.mvc.domain.Realtor;
import com.jinanging.spring.test.mvc.respository.RealtorRepository;

@Service
public class RealtorService {
	
	@Autowired
	private RealtorRepository realtorRepository;
	
	
	public int addRealtor(Realtor realtor) {
		int count = realtorRepository.insertRealtor(realtor);
		return count;
		
		
	}

}
