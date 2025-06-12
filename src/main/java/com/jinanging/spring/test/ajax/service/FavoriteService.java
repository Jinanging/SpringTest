package com.jinanging.spring.test.ajax.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinanging.spring.test.ajax.domain.Favorite;
import com.jinanging.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	FavoriteRepository favoriteRepository;
	
	public int addFavorite(Favorite favorite) {
		int count = favoriteRepository.inputFavorite(favorite);
		return count;
	}
	
	public List<Favorite> selectAllFavorite(){
		List<Favorite> favoriteList = favoriteRepository.selectFavorite();
		return favoriteList;
		
		
	}
	
	public int deleteFavorite(@Param("id") int id) {
		int count = favoriteRepository.deleteFavorite(id);
		
		return count;
	}
	

}
