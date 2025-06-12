package com.jinanging.spring.test.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinanging.spring.test.thymeleaf.domain.StoreReview;
import com.jinanging.spring.test.thymeleaf.repository.StoreReviewRepository;

@Service
public class StoreReviewService {
	
	@Autowired
	StoreReviewRepository storeRepository;
	
	public List<StoreReview> getStore(){
		List<StoreReview> storeList = storeRepository.selectStore();
		return storeList;
			
	};

	}
