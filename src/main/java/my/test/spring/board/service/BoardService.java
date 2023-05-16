package my.test.spring.board.service;

import java.util.List;

import my.test.spring.board.vo.BoardVO;
import my.test.spring.user.vo.UserVO;

public interface BoardService {
	
	void createBoard(BoardVO boardvo);   // 게시글 생성(등록)
	List<BoardVO> readBoard();           // 게시글 조회
	BoardVO readOneBoard(int boardId);   // 게시물 세부사항 조회
	void updateBoard(BoardVO boardvo);   // 게시글 수정
	void deleteOneBoard(int boardId);       // 게시글 삭제

}
