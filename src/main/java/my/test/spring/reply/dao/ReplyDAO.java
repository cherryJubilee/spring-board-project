package my.test.spring.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.test.spring.reply.vo.ReplyVO;

@Repository
public class ReplyDAO {
	
Logger log = LogManager.getLogger("case3");
	
	@Autowired
    private SqlSession sqlSession;
	
	// 댓글 조회
	public List<ReplyVO> selectAllReplys() {
		// TODO Auto-generated method stub
		
		return null;

	}
	
	// 댓글 -> db에 넣기
	public void insertReply(ReplyVO replyvo) throws Exception {
		
		int resultvo = sqlSession.insert("myReply.insertReply", replyvo);
		
		log.debug(resultvo); //1 : 성공
		
	}
	
}
