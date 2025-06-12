package com.jinanging.spring.test.thymeleaf;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jinanging.spring.test.thymeleaf.domain.WeatherHistory;
import com.jinanging.spring.test.thymeleaf.service.WeatherService;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherhistoryController {
	
	//Model 에다가 객체 저장하고 페이지로 넘어가게 하기 
	
	@Autowired
	private WeatherService weatherService;
	
	
	//날씨정보 리스트 얻어오기
	@GetMapping("/list")
	public String weatherList(Model model) {
		
		//데어트를 얻어오는 기능 
		List<WeatherHistory> weatherHistory = weatherService.getWeatherHistory();
		model.addAttribute("weatherHistory",weatherHistory);
		
		
		return "thymeleaf/weather/weatherInfo";
		
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		
		return "thymeleaf/weather/weatherInput";
	}
	
	@PostMapping("/add")
	public String weatherAdd(@RequestParam("date") LocalDate date
							,@RequestParam("weather")String weather
							,@RequestParam("microDust") String microDust
							,@RequestParam("precipitation") double precipitation
							,@RequestParam("temperatures") double temperatures
							,@RequestParam("windSpeed") double windSpeed
							,Model model) {
		WeatherHistory weatherHistory = new WeatherHistory();
		weatherHistory.setMicroDust(microDust);
		weatherHistory.setDate(date);
		weatherHistory.setPrecipitation(precipitation);
		weatherHistory.setTemperatures(temperatures);
		weatherHistory.setWeather(weather);
		weatherHistory.setWindSpeed(windSpeed);
		
		weatherService.addWeather(weatherHistory);
		
		model.addAttribute("weatherHistory",weatherHistory);
		
		return "redirect:/thymeleaf/weather/list";
		
		
		
		
		
		
	}

							
	

}
