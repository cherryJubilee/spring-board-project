package my.test.spring.board.controller;

import java.util.List;

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

import my.test.spring.board.service.BoardService;
import my.test.spring.board.vo.BoardVO;


@Controller
@RequestMapping("board")
@SessionAttributes("boardList")
public class BoardController {
	
	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private BoardService boardservice;
	
	// 게시글 리스트 보여주기
	@GetMapping("list")
	public String boardList(Model model) {
		List<BoardVO> boardList = boardservice.readBoard();
		model.addAttribute("boardList", boardList);
		return "board";
	}
	
	// 게시판 -> 글작성 페이지로 이동
	@GetMapping("create")
	public String createBoardPage() {
		
		return "board-create";
	}
	
	// 글작성 하기
	@PostMapping("board-create")
	public String createBoard(BoardVO boardvo) {
		boardservice.createBoard(boardvo);
		
		return "redirect:/board";
	}
	
	// 글작성 하고 제출하기
	@PostMapping("submit_board")
	public String submitBoard(BoardVO boardvo) {
		
		log.debug(boardvo);
		boardservice.createBoard(boardvo);
		
		return "redirect:/board/list";

	}
	
	// 회원정보 수정: 게시판 -> 마이페이지로 이동
	@GetMapping("mypage")
	public String createMyPage() {
		
		return "mypage";
	}

	// 게시판으로 돌아가기 버튼: 마이페이지 -> 게시판으로 이동
	@GetMapping("board")
	public String goBoard() {
		
		return "redirect:/board/list";
	}
	
	// 게시판 상세보기
	@GetMapping("/detail/{boardId}")
	public String readOneBoard(@PathVariable("boardId") int boardId, Model model) {
		
		BoardVO vo = boardservice.readOneBoard(boardId);
		model.addAttribute("board", vo);
		
		return "board-detail";
		
	}
	
	// 게시글 수정 (게시판 상세보기 -> 글 수정 버튼 누르면-> board-edit.jsp로 이동)
	@GetMapping("/detail/update/{boardId}")
	public String updateBoard(@PathVariable("boardId") int boardId, Model model) {
		
		BoardVO vo = boardservice.readOneBoard(boardId);
		model.addAttribute("editboard",vo);

		return "board-edit";
	}
	
	// 게시글 수정 페이지 -> 게시글 페이지로 돌아가기
	@PostMapping("/updateBoard/{boardId}")
	public String goBoard2(@ModelAttribute("editboard") BoardVO boardvo, @PathVariable("boardId") int boardId) {
		
		boardvo.setBoardId(boardId);
		log.debug(boardvo);
		boardservice.updateBoard(boardvo); // 게시글을 수정하는 서비스 메소드
		
		return "redirect:/board/list"; // 수정 후 게시글 목록 페이지로 리다이렉트
	}
	

	
	// 게시글 삭제 (글삭제 버튼 누르면 게시글 삭제 되도록 하기)
	@GetMapping("/detail/delete/{boardId}")
	public String deleteBoard(@PathVariable("boardId") int boardId) {
		
		boardservice.deleteOneBoard(boardId);
		
		return "redirect:/board/list";

	}
		
	
}
