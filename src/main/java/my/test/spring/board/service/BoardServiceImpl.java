package my.test.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import my.test.spring.board.dao.BoardDAO;
import my.test.spring.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;

	// Transaction
	@Autowired
	private PlatformTransactionManager transactionManager;

	// 게시글 생성(등록) 
	@Override
	public void createBoard(BoardVO boardvo) {
		// Transaction 처리
		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		boolean result = false;

		try {
			boardDao.insert(boardvo);

			// 정상적으로 처리가 되었으니까 commit처리 하기!
			result = true;
			transactionManager.commit(txStatus);

		} catch (Exception e) {
			result = false;
			transactionManager.rollback(txStatus);
		}

	}

	
	// 게시글 조회
	@Override
	public List<BoardVO> readBoard() {

		List<BoardVO> result = boardDao.selectAllBoards();

		return result;
	}

	// 게시판 상세보기
	@Override
	public BoardVO readOneBoard(int boardId) {
		
		return boardDao.selectOneBoard(boardId);
		
	}
	

	// 게시글 수정
	@Override
	public void updateBoard(BoardVO boardvo) {
	    boardDao.updateOneBoard(boardvo);
	}

	//게시글 삭제 
	@Override
	public void deleteOneBoard(int boardId) {

		boardDao.removeOneBoard(boardId);
		
	}




}
