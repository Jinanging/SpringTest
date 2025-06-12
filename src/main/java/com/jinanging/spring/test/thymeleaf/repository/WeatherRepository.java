package com.jinanging.spring.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jinanging.spring.test.thymeleaf.domain.WeatherHistory;

@Mapper
public interface WeatherRepository {
	
	public List<WeatherHistory> selectWeatherHistory();
	

	public int insertWeather(WeatherHistory weatherHistory);
	

}
