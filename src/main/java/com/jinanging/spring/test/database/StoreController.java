package com.jinanging.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinanging.spring.test.database.domain.Store;
import com.jinanging.spring.test.database.service.StoreService;

@Controller
public class StoreController {
	@Autowired
	private StoreService StoreService;
	
	@RequestMapping("db/store/list")
	@ResponseBody
	public List<Store> StoreList(){
		
		List<Store> storeList = StoreService.getStoreList();
		return storeList;
		
	}
	
	

}
