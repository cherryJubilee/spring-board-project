package my.test.spring.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import my.test.spring.reply.dao.ReplyDAO;
import my.test.spring.reply.vo.ReplyVO;


@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replydao;

	// Transaction
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	// 댓글 조회
	@Override
	public List<ReplyVO> readAllReply(int boardId) {
		
		List<ReplyVO> result = replydao.selectAllReplys();
		
		return result;
		
	}
	
	
	
	// 댓글 생성(등록)
	@Override
	public void createReply(ReplyVO replyvo) {
		
		TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		boolean result = false;
		try {
			replydao.insertReply(replyvo);
			result = true;
			transactionManager.commit(txStatus);
		} catch (Exception e) {
			result = false;
			transactionManager.rollback(txStatus);
		}
	}

}
