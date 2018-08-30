package com.giant.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giant.project.dao.BoardDao;
import com.giant.project.model.Board;
import com.giant.project.model.Detail;
import com.giant.project.model.Member;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
//	@Resource(name="boardDao" )
//	private BoardDao bd;
	
	@Autowired
	public BoardDao bd;

	@Override
	public Member login(Member member) {
		return bd.login(member);
	}

	@Override
	public int writeViewSelect() {
		return bd.writeViewSelect();
	}

	@Override
	public int temporarilyinsert(Board board) {
		return bd.temporarilyinsert(board);
	}

	@Override
	public ArrayList<Board> getSearchDate(Board board) {
		return (ArrayList<Board>)bd.getSearchDate(board);
	}

	@Override
	public int selectjob(Board board) {
		return bd.selectjob(board);
	}

	@Override
	public Board postBoard(int post_no) {
		return bd.postBoard(post_no);
	}

	@Override
	public int post_noUpdate(Board board) {
		return bd.post_noUpdate(board);
	}

	@Override
	public int post_noGiveback(Board board) {
		return bd.post_noGiveback(board);
	}

	@Override
	public int post_detailinsert(Board board) {
		return bd.post_detailinsert(board);
	}

	@Override
	public ArrayList<Detail> postDetail(int post_no) {
		return (ArrayList<Detail>) bd.postDetail(post_no);
	}

	@Override
	public List<Board> list() {
		return bd.List();
	}

	@Override
	public List<Map<String, Object>> miSelectList(Map<String, Object> map) {
		return bd.miSelectList(map);
	}

	
	
	
	
}
