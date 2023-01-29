package com.practice.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practice.model.BoardVO;
import com.practice.model.Criteria;
import com.practice.model.PageMakerDTO;
import com.practice.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;

//	@GetMapping("/list")
//    
//    public void boardListGET(Model model) {
//        
//		log.info("게시판 목록 페이지 진입");
//		
//		model.addAttribute("list",boardService.getList());
//        
//    }

	/* 게시판 목록 페이지 접속(페이징 적용) */
	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {

		log.info("boardListGET");

		model.addAttribute("list", boardService.getListPaging(cri));

		int total = boardService.getTotal();

		PageMakerDTO pageMake = new PageMakerDTO(cri, total);

		model.addAttribute("pageMaker", pageMake);

	}

	@GetMapping("/enroll")

	public void boardEnrollGET() {

		log.info("게시판 등록 페이지 진입");

	}

	/* 게시판 등록 */
	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {

		log.info("BoardVO : " + board);

		boardService.enroll(board);

		rttr.addFlashAttribute("result", "enrol success");

		return "redirect:/board/list";

	}

	/* 게시판 조회 */
	@GetMapping("/get")
	public void boardGetPageGET(int bno, Model model) {

		model.addAttribute("pageInfo", boardService.getPage(bno));

	}

	/* 수정 페이지 이동 */
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model) {

		model.addAttribute("pageInfo", boardService.getPage(bno));

	}

	/* 페이지 수정 */
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {

		boardService.modify(board);

		rttr.addFlashAttribute("result", "modify success");

		return "redirect:/board/list";

	}

	/* 페이지 삭제 */
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {

		boardService.delete(bno);

		rttr.addFlashAttribute("result", "delete success");

		return "redirect:/board/list";
	}

}
