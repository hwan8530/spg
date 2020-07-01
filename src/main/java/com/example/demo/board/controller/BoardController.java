package com.example.demo.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.annotation.ModelMethodProcessor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.service.FreeBoardService;
import com.example.demo.board.domain.*;

@Controller
public class BoardController {
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	// 자유게시판
	@RequestMapping(value = "freeBoard")
	public ModelAndView goFreeBoard(HttpSession session) {
		
		System.out.println(">>> 자유게시판");
		
		// test code
		List<FreeBoard> list = this.freeBoardService.findAll();
		System.out.println(list.get(0).getTitle());
		// end test code

		String name = (String)session.getAttribute("name");
		String userName = (String)session.getAttribute("userName");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/free_board");
		mav.addObject("userName", userName);
		mav.addObject("name", name);
		
		return mav;
	}
	
	@RequestMapping(value = "freeBoard/detail")
	public String goFreeBoardDetail() {
		
		return "/board/free_board_detail";
	}
	
	// 교육게시판
	@RequestMapping(value = "eduBoard")
	public String goEducationBoard() {
		
		return "board/education_board";
	}
	
	// 갤러리
	@RequestMapping(value = "gallery")
	public String goGallery() {
		
		return "board/gallery";
	}
	
	// 공지사항
	@RequestMapping(value = "notice")
	public String goNotice() {
		
		return "admin/notice";
	}
	
	// 글작성
	@RequestMapping(value = "write")
	public ModelAndView goWrite() {
		
		String contentWriter = "서강준"; // 임시 작성자 데이터, 로그인 세션에서 데이터 따와야함
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("write-page");
		mav.addObject("content_writer", contentWriter);

		return mav;
	}
	
	@RequestMapping(value="doWrite")
	public String doWrite() {
		
		FreeBoard testWrite = new FreeBoard("테스트 타이틀", 1, "존", "테스트 컨텐트");
		this.freeBoardService.save(testWrite);
		
		return "/";
	}
}
