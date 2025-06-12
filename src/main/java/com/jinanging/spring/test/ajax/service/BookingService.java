package com.jinanging.spring.test.ajax.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinanging.spring.test.ajax.domain.Booking;
import com.jinanging.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	public List<Booking> getBooking(){
		List<Booking> bookList = bookingRepository.selectBooking();
		return bookList;
		
	}
	public int deleteBooking(@Param("id") int id) {
		int count = bookingRepository.deleteBooking(id);
		
		return count;
	}
	
	public int addBooking(Booking booking) {
		
		int count = bookingRepository.insertBooking(booking);
		return count;
		
	}
	
	public Booking checkSelectBook(@Param("name") String name, @Param("phoneNumber")  String phoneNumber) {
		
		Booking book = bookingRepository.checkSelect(name,phoneNumber);
		
		return book;
		
		
	}
	

}
