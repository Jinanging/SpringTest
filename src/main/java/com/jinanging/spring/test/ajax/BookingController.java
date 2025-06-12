package com.jinanging.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinanging.spring.test.ajax.domain.Booking;
import com.jinanging.spring.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax")
public class BookingController {
	
	@Autowired
	BookingService bookingService;	
	
	
	
	@GetMapping("/booking")
	public String bookingInfo() {
		return "ajax/booking/book";
	}
	
	@GetMapping("/bookingList")
	public String bookingList(Model model) {
		List<Booking> bookList = bookingService.getBooking();
		model.addAttribute("bookList",bookList);
		
		return "ajax/booking/bookingList";
	}
	
	@GetMapping("/bookingInput")
	public String bookingInput() {
		return "ajax/booking/bookingInput";
	}
	
	
	@GetMapping("/check")
	@ResponseBody
	public Map<String,Object> bookingCheck(@RequestParam("name") String name
											,@RequestParam("phoneNumber") String phoneNumber){
		Booking selectBook = new Booking();
		selectBook = bookingService.checkSelectBook(name, phoneNumber);
		Map<String,Object> checkMap = new HashMap<>();
		if(selectBook!=null) {
			
			checkMap.put("result", "success");
			checkMap.put("checkMap", selectBook);
		}
		else {
			checkMap.put("result", "fail");
			
		}
		
		return checkMap;
		
		
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String,String> delete(@RequestParam("id") int id) {
		
		int count = bookingService.deleteBooking(id);
		Map<String,String> deleteMap = new HashMap<>();
		if(count ==1) {
			
			deleteMap.put("deleteResult", "success");
		}
		else {
			deleteMap.put("deleteResult", "fail");
			
		}
		
		return deleteMap;
	}
	
	@GetMapping("/insert")
	@ResponseBody
	public Map<String,String> insert(@RequestParam("name") String name
									,@RequestParam("date") String date
									,@RequestParam("day") int day
									,@RequestParam("headCount") int headCount
									,@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking insertBook = new Booking();
		insertBook.setName(name);
		insertBook.setDate(date);
		insertBook.setDay(day);
		insertBook.setHeadCount(headCount);
		insertBook.setPhoneNumber(phoneNumber);
		
		int count = bookingService.addBooking(insertBook);
		
		Map<String,String> bookingMap = new HashMap<>();
				
				if(count == 1) {
					bookingMap.put("result", "success");
					
				}
				else {
					bookingMap.put("result", "fail");
					
				}
		
		return bookingMap;
		
	}
		
	
	

}
