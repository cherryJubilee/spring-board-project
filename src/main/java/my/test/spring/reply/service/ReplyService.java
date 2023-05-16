package my.test.spring.reply.service;

import my.test.spring.reply.vo.ReplyVO;

public interface ReplyService {
	
	void readAllReply(int boardId);
	void createReply(ReplyVO replyvo);
	

}
