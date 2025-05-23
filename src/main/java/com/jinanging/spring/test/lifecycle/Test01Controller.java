package com.jinanging.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test01Controller {
	
	@RequestMapping("/1")
	public String Print() {
		return ""
				+ "<html>\n"
				+ "		<head><title> html 출력 </title></head>\n"
				+ "		<body>\n"
				+ "			<h3>테스트 프로젝트 완성</h3>\n"
				+ "			<div>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</div>\n"
				+ "		</body>\n"
				+ "</html>";
		
	}
	
	@RequestMapping("/2")
	public Map<String,Integer> JsonPrint() {
		Map<String,Integer> score = new HashMap<>();
		score.put("국어", 80);
		score.put("수학", 90);
		score.put("영어", 85);
		return score;
	}
	
	

}
