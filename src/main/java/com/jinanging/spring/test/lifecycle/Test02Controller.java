package com.jinanging.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lifecycle/test02")
public class Test02Controller {
	
	@RequestMapping("/1")
	public List<Map<String,Object>> jsonPrint(){
		List<Map<String,Object>> movieInfo = new ArrayList<>();
		Map<String,Object> movie1 = new HashMap<>();
		movie1.put("rate", 15);
		movie1.put("director", "봉준호");
		movie1.put("time", 131);
		movie1.put("title", "기생충");
		movieInfo.add(movie1);
		Map<String,Object> movie2 = new HashMap<>();
		movie2.put("rate", 0);
		movie2.put("director", "르베르토 베니니");
		movie2.put("time", 116);
		movie2.put("title", "인생은 아름다워");
		movieInfo.add(movie2);
		Map<String,Object> movie3 = new HashMap<>();
		movie3.put("rate", 12);
		movie3.put("director", "크리스토퍼 놀란");
		movie3.put("time", 147);
		movie3.put("title", "인셉션");
		movieInfo.add(movie3);
		Map<String,Object> movie4 = new HashMap<>();
		movie4.put("rate", 19);
		movie4.put("director", "윤종빈");
		movie4.put("time", 133);
		movie4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movieInfo.add(movie4);
		Map<String,Object> movie5 = new HashMap<>();
		movie5.put("rate", 15);
		movie5.put("director", "프란시스 로렌스");
		movie5.put("time", 137);
		movie5.put("title", "헝거게임");
		movieInfo.add(movie5);
		
		return movieInfo;
		
		
	}
	
	@RequestMapping("/2")
	public List<NoticeBoard> postPrint(){
		
	    NoticeBoard post1 = new NoticeBoard("안녕하세요 가입인사드립니다", "hagulu", "안녕하세요 가입했어요 앞으로 잘 부탁드립니다 활동 열심히 하겠습니다");
	    NoticeBoard post2 = new NoticeBoard("헐 대박", "bada", "오늘 목요일이였어 금요일인줄");
	    NoticeBoard post3 = new NoticeBoard("오늘 데이트한 이야기 해드릴게요", "dulumary", "...");

	    List<NoticeBoard> board = new ArrayList<>();
	    board.add(post1);
	    board.add(post2);
	    board.add(post3);

	    return board;
	}

	

}
