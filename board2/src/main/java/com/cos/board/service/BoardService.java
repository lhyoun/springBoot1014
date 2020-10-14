package com.cos.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.board.config.ex.MyArgsNouFound;
import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 글 작성
	/*@Transactional
	public void createBoard(BoardSaveRequestDto dto) {
		boardRepository.save(BoardSaveRequestDto.toEntity(dto));
	}*/
	
	// 글 작성
	@Transactional
	public void createBoard(BoardSaveRequestDto dto) {
		boardRepository.save(BoardSaveRequestDto.toEntity(dto));
	}
	
	// 글 목록 보기
	@Transactional(readOnly = true)
	public List<Board> getListBoard() {
		return boardRepository.findAll();
	}
	
	// 글 상세 보기
	@Transactional
	public Board detailBoard(int id) {
		//Board board = boardRepository.findById(id).orElseThrow(()->new MyArgsNouFound("ID값 잘못 들어왔어요"));
		Board boardEntity = boardRepository.findById(id).orElseThrow(()->new RuntimeException("ID값 잘못 들어왔어요"));
		// RuntimeException : Exception을 상속받은 class, spring에서 RuntimeException을 걸어야 rollback이 가능하다(실패하면 잡아서 rollback해줌). try-catch가 필요없다
		// 사실 select라 rollback이 필요없긴 하다. 서비스에서 ex처리를 할 떄는 runtimeException의 자식을 던져라. runtime으로 상속한 class만들어서 던지거나 또는 최고 부모
		boardEntity.setReadCount(boardEntity.getReadCount()+1);
		return boardEntity;
	}
	
	// 글 삭제
	@Transactional
	public void deleteBoard(int id) {
		//boardRepository.deleteById(id);
		boardRepository.mDeleteById(id);
	}
	
	// 글 수정
	@Transactional
	public void alterBoard(int id, BoardSaveRequestDto dto) {
		//Board board = BoardSaveRequestDto.toEntity(dto);
		//board.setId(id);
		//boardRepository.save(board);
		// save방식으로 update하려면 모든 data를 다 받아야 한다
		
		// 더티 체킹
		//Board boardEntity = boardRepository.findById(id).orElseThrow(()->new RuntimeException("ID값 잘못들어왔어요."));
		Board boardEntity = boardRepository.mFindById(id).get();
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
	}
}
