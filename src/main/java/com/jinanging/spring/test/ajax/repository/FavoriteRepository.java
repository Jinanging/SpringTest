package com.jinanging.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jinanging.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {

	
	public int inputFavorite(Favorite favorite);
	
	public List<Favorite> selectFavorite();
	
	public int deleteFavorite(@Param("id") int id);
	
	
	

}
