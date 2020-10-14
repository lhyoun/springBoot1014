package com.cos.board.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cos.board.config.ex.MyArgsNouFound;
import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;
import com.cos.board.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardConroller {

	private BoardService boardService;
	
	// http://localhost:8000/board/saveForm
	@GetMapping("/saveForm")
	public String saveForm() {
		return "saveForm";
	}
	

	
	// 글 쓰기
	/*@PostMapping("/save") 
	public String save(BoardSaveRequestDto dto) { 
		boardService.createBoard(dto);
		return "redirect:list"; 
	}*/
	
	/*@PostMapping("/save") 
	public String save(@RequestBody BoardSaveRequestDto dto) { 
		boardService.createBoard(dto);
		return "redirect:list"; 
	}*/
	
	@PostMapping("/save") 
	@ResponseBody
	public String save(@RequestBody BoardSaveRequestDto dto) { 
		boardService.createBoard(dto);
		return "ok"; 
	}
	
	// 글 목록 보기
	@GetMapping({"","/","/list"})	// 이 3개의 주소 다 받아준다
	public String list(Model model) {
		model.addAttribute("boards", boardService.getListBoard());
		return "list";
	}
	
	// 글 상세보기
	@GetMapping("/{id}")
	public String detail(@PathVariable int id, Model model) throws MyArgsNouFound {
		model.addAttribute("board", boardService.detailBoard(id));
		return "detail";
	}
	
	// 글 삭제
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable int id) {
		boardService.deleteBoard(id);
		return "ok";
	}	
	
	// 글 수정
	@PutMapping("/{id}")
	@ResponseBody
	public String update(@PathVariable int id, @RequestBody BoardSaveRequestDto dto) {
		boardService.alterBoard(id, dto);
		return "ok";
	}
	

	
}
// contoller의 method의 파라메터 부분은 자동 DI가 됨