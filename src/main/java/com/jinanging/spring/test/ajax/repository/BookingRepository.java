package com.jinanging.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinanging.spring.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {
	
	public List<Booking> selectBooking();
	
	public int deleteBooking(@Param("id") int id);
	
	public int insertBooking(Booking booking);
	

	
	public Booking checkSelect(@Param("name") String name
								,@Param("phoneNumber") String phoneNumber);
	

}
