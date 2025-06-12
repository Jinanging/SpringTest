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

import com.jinanging.spring.test.ajax.domain.Favorite;
import com.jinanging.spring.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {
	
//	@PostMapping("/create")
//	public createFavorite(
//			@RequestParam("name") String name
//			,@RequestParam("url") String url
//			){
//		
//		
//		
//		
//		
//	};
	
	@Autowired
	FavoriteService favoriteService;
	
	@ResponseBody
	@GetMapping("/compare")
	public Map<String,String> compareUrl(@RequestParam("url") String url){
		Favorite favorite = new Favorite();
		favorite.setUrl(url);
		List<Favorite> favoriteCompare = favoriteService.selectAllFavorite();
		boolean compare = false;
		for(Favorite favoriteUrl : favoriteCompare) {
			if(favoriteUrl.getUrl().equals(url)) {
				compare = true;
				
			}
		}
		Map<String,String> compareMap = new HashMap<>();
		if(compare == true) {
			compareMap.put("check", "duplicate");
		}
		else {
			compareMap.put("check", "IsnotDuplicate");
		}
		return compareMap;
		
	
		
		
		
	}
	
	
	@ResponseBody
	@GetMapping("/create")
	public Map<String,String> inputFavorite(
			@RequestParam("name") String name
			,@RequestParam("url") String url) {
		
		Favorite favorite = new Favorite();
		favorite.setName(name);
		favorite.setUrl(url);
		
		
		int count = favoriteService.addFavorite(favorite);
		
		Map<String,String> favoriteMap = new HashMap<>();
		
		if(count == 1) {
			favoriteMap.put("result", "success");
			
		}
		else {
			favoriteMap.put("result", "fail");
			
		}
		
		
		return favoriteMap;
	}
	
	// view 생성
	
	@GetMapping("/input")
	public String inputView() {
		return "/ajax/input";
	}
	
	@GetMapping("/select")
	public String selectView(Model model) {
		List<Favorite> favorite = favoriteService.selectAllFavorite();
		model.addAttribute("favoriteInfo" , favorite);
		
		return "/ajax/select";
	}
	
	@GetMapping("delete")
	@ResponseBody
	public Map<String,String> delete(@RequestParam("id") int id) {
		
		int count = favoriteService.deleteFavorite(id);
		Map<String,String> deleteMap = new HashMap<>();
		if(count ==1) {
			
			deleteMap.put("deleteResult", "success");
		}
		else {
			deleteMap.put("deleteResult", "fail");
			
		}
		
		return deleteMap;
	}
	

}
