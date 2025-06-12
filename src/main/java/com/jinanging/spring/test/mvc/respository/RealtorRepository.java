package com.jinanging.spring.test.mvc.respository;

import org.apache.ibatis.annotations.Mapper;

import com.jinanging.spring.test.mvc.domain.Realtor;

@Mapper
public interface RealtorRepository {
	
	
	public int insertRealtor(Realtor realtor);
	
	

}
