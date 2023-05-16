package my.test.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.test.spring.board.vo.BoardVO;

@Repository
public class BoardDAO {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
    private SqlSession sqlSession;
	
	// 게시글 등록 -> db에 넣기
	public void insert(BoardVO boardvo) throws Exception {
		
		sqlSession.insert("myBoard.insertBoard", boardvo);
		
	}

	// 게시글 조회하기
	public List<BoardVO> selectAllBoards() {

		List<BoardVO> list = null;
		
		list = sqlSession.selectList("myBoard.selectBoard"); 
		
		log.debug("boardList 들어오는지 확인");

		return list;
	}
	
	
	// 게시판 상세보기
	public BoardVO selectOneBoard(int boardId) {
		
		return sqlSession.selectOne("myBoard.selectOneBoard", boardId);
		
	} 
	
	// 게시글 수정
	public void updateOneBoard(BoardVO boardvo) {
		
		
		int result = sqlSession.update("myBoard.updateBoard", boardvo);
		
		log.debug("dao 확인" + result);
		
	}
	
	//게시글 삭제
	public void removeOneBoard(int boardId) {
		
		sqlSession.delete("myBoard.deleteBoard", boardId);
	}
}
