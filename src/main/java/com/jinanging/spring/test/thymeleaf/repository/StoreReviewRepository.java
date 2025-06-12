package com.jinanging.spring.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jinanging.spring.test.thymeleaf.domain.StoreReview;

@Mapper
public interface StoreReviewRepository {
	
	public List<StoreReview> selectStore();
	
	
	

}
