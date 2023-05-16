package my.test.spring.reply.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.test.spring.reply.service.ReplyService;
import my.test.spring.reply.vo.ReplyVO;
import my.test.spring.user.vo.UserVO;

@Controller
@RequestMapping("reply")
@SessionAttributes("replyList")
public class ReplyController {

	Logger log = LogManager.getLogger("case3");

	@Autowired
	private ReplyService replyservice;

	@ModelAttribute(value = "replys")
	public ReplyVO createReply() {

		return new ReplyVO();
	}

	@GetMapping(value = "/board/post/{boardId}/comment")
	public void commentReadHandler(@PathVariable("boardId") int boardId, @ModelAttribute("replys") ReplyVO reply,
			Model model) {

		log.debug("controller {}", reply);

		UserVO user = (UserVO) model.getAttribute("userInfo");
		reply.setBoardId(boardId);
		replyservice.readAllReply(boardId);
	}

	@PostMapping(value = "/board/post/{boardId}/comment")
	public String commentCreatHandler(@PathVariable("boardId") int boardId, @ModelAttribute("replys") ReplyVO reply,
			Model model) {

		log.debug("controller {}", reply);

		UserVO user = (UserVO) model.getAttribute("userInfo");
		reply.setBoardId(boardId);
		replyservice.createReply(reply);
		return "redirect:/board/post/" + boardId;
	}

}
