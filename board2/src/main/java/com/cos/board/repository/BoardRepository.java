package com.cos.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.board.model.Board;

// 자동 IoC 등록됨(JpaRepository)
public interface BoardRepository extends JpaRepository<Board, Integer>{	
// repository는 object 관리하는 애. 첫 번째에 관리하고자 하는 obj
	
	// select * from board(여기까지 고정) where title(findBy 뒤 꺽이는 부분부터 들어옴) = ? 라는 쿼리를 날려줌. ?에 들어갈 값은 (String title) 
	Board findByTitle(String title);
	// findBy까지는 고정(문법) 
	
	// select * from board where title = ?1 and content = ?2
	Board findByTitleAndContent(String title, String content);
	
	// 이런게 있긴 하지만 그냥 쿼리로 하는게 쉬움
	
	
	
	// public abstract 생략되어있음. interface안의 추상메서드니까
	
	@Query(value = "select * from board where id = :id", nativeQuery = true)
	Optional<Board> mFindById(int id);
	//Board mFindById(int id);
	
	@Modifying // 수정 삭제 저장에 걸어줘야 커밋을 한다
	@Query(value = "delete from board where id = :id", nativeQuery = true)
	int mDeleteById(int id);
}
// 내부적으로 CRUD를 다 가지고 있다. paging도