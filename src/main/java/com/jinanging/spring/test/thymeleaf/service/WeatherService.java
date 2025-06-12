package com.jinanging.spring.test.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinanging.spring.test.thymeleaf.domain.WeatherHistory;
import com.jinanging.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	
	// 모든 날씨 정보 리스트 얻어오기
	@Autowired
	public WeatherRepository weatherRepository;
	
	public List<WeatherHistory> getWeatherHistory(){
		//weatherhistory 테이블 모든 행 조회
		List<WeatherHistory> weatherHistory = weatherRepository.selectWeatherHistory();
		return weatherHistory;
		
	}
	
	public int addWeather(WeatherHistory weatherHistory) {
		int count = weatherRepository.insertWeather(weatherHistory);
		return count;
		
	}
	
	
	
	
	
	

}
