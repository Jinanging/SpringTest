package com.jinanging.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinanging.spring.test.mybatis.domain.Estate;

@Mapper
public interface EstateRepository {
	
	public Estate selectEstate(@Param("id") int id);
	
	public List<Estate> optionEstate(@Param("rentPrice") int rentPrice);
	
	public List<Estate> selectRealEstateByAreaAndPrice(
						@Param("area") int area
						,@Param("price") int price);
	
	public int insertRealEstateByObject(Estate Estate);
	
	public int insertRealEstate(
				@Param("realtorId") int realtorId
				,@Param("address") String address
				,@Param("area") int area
				,@Param("type") String type
				,@Param("price") int price
				,@Param("rentPrice") int rentPrice);
	
	public int updateRealEstate(
				@Param("id") int id
				,@Param("type") String type
				,@Param("price") int price);
	
	public int deleteRealEstate(@Param("id") int id);
	
	
	
	
}
