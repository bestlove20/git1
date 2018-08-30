package com.giant.project.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.giant.project.model.Board;
import com.giant.project.model.Detail;
import com.giant.project.model.Member;
import com.giant.project.service.BoardService;
import com.giant.project.controller.ProductExcelDownload;




@Controller
public class BoardController {
	
	/*@Resource(name = "bs" )
	private BoardService bs;*/
	@Autowired
	private BoardService bs;
	
	@RequestMapping(value = "loginpage")
	public String loginpage(){
		
		return "views/login";
	}
	
	@RequestMapping(value = "login" , method = RequestMethod.POST)
	public String login(HttpSession session, Member member, Model model){
		Member resultMember = bs.login(member);
		System.out.println(resultMember.getMem_job());
		int job = resultMember.getMem_job();
		System.out.println(job);
		
		if (resultMember == null) {
			
				return "views/login";
		} else {
			// 성공
			model.addAttribute("job", job);
			session.setAttribute("member", resultMember); // session 에 email    jsppage 참고
			return "redirect:list";
		}
	}
	
	@RequestMapping(value = "list")
	public String list(Model model, Board board, int job){
		System.out.println("list job = " + job);
		board.setStatus(job);
		ArrayList<Board> list = bs.getSearchDate(board);
		
		model.addAttribute("list", list);
		
		return "views/list";
	}
	@RequestMapping(value = "writeView")
	public String writeView(Member member, Model model){
		
		int post_no = bs.writeViewSelect();
		model.addAttribute("member", member);
		model.addAttribute("post_no", post_no);
		return "views/writeView";
	}
	
	@RequestMapping(value = "temporarily" , method = RequestMethod.POST)
	public String temporarily(Board board, Model model){
		System.out.println("Status = "+board.getStatus());
		System.out.println("Mem_id = "+board.getMem_id());
		System.out.println("Post_no = "+board.getPost_no());
		System.out.println("Subject = "+board.getSubject());
		System.out.println("Content = "+board.getContent());
		
		
		// 게시글 등록 
		bs.temporarilyinsert(board);
		// 직급 확인
		System.out.println("직급확인");
		int job = bs.selectjob(board);
		model.addAttribute("job", job);
		System.out.println(job);
		
		return "redirect:list";
	}
	// 게시글 결제 등록
	@RequestMapping(value = "payment_request")
	public String payment_request(Board board, Model model){
		System.out.println("Status = "+board.getStatus());
		System.out.println("Mem_id = "+board.getMem_id());
		System.out.println("Post_no = "+board.getPost_no());
		System.out.println("Subject = "+board.getSubject());
		System.out.println("Content = "+board.getContent());
		System.out.println("status = " + board.getStatus());
		 bs.temporarilyinsert(board); // board
		 bs.post_detailinsert(board); // 디테일  post_no 11-1 = 10
		int job = bs.selectjob(board);
		model.addAttribute("job", job);
		return "redirect:list";
	}
	// 게시글 디테일 화면 select
	@RequestMapping(value = "post_detail")
	public String post_detail(int post_no, Model model){
		System.out.println("post_no = " + post_no);
		Board board = bs.postBoard(post_no);
		ArrayList<Detail> list = bs.postDetail(post_no);
		model.addAttribute("board", board);
		model.addAttribute("list", list);
		
		return "views/post_detail";
	}
	
	@RequestMapping(value = "post_noUpdate")
	public String post_noUpdate(Board board){
		System.out.println("update.post_no = "+board.getPost_no());
		System.out.println("update.status = "+board.getStatus());
		int result = bs.post_noUpdate(board); // board 결제 상태 업데이트
											  // 결제 승인 시 detail테이블에 히스토리 남기기
		return "views/login";
	}
	
	@RequestMapping(value = "post_noGiveback") 
	public String post_noGiveback(Board board){
		System.out.println("update.post_no = "+board.getPost_no());
		System.out.println("update.status = "+board.getStatus());
		int result = bs.post_noGiveback(board);
		
		return "views/login";
	}
	
	@RequestMapping(value="test")
	public View excel(Model model){
		List<Board> list = bs.list();
		model.addAttribute("list", list);
		return (View)new ProductExcelDownload();
	}

}
