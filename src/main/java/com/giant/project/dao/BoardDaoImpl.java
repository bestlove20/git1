package com.giant.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.giant.project.model.Board;
import com.giant.project.model.Detail;
import com.giant.project.model.Member;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public Member login(Member member) {
		return session.selectOne("board.login", member);
	}

	@Override
	public int writeViewSelect() {
		return session.selectOne("writeViewSelect");
	}

	@Override
	public int temporarilyinsert(Board board) {
		return session.insert("temporarily", board);
	}

	@Override
	public List<Board> getSearchDate(Board board) {
		return session.selectList("getSearchDate", board);
	}

	@Override
	public int selectjob(Board board) {
		return session.selectOne("selectjob", board);
	}

	@Override
	public Board postBoard(int post_no) {
		return session.selectOne("postBoard", post_no);
	}

	@Override
	public int post_noUpdate(Board board) {
		return session.update("post_noUpdate", board);
	}

	@Override
	public int post_noGiveback(Board board) {
		return session.update("post_noGiveback", board);
	}

	@Override
	public int post_detailinsert(Board board) {
		return session.insert("post_detailinsert", board);
	}

	@Override
	public List<Detail> postDetail(int post_no) {
		return session.selectList("postDetail", post_no);
	}

	@Override
	public java.util.List<Board> List() {
		return session.selectList("list");
	}

	@Override
	public java.util.List<Map<String, Object>> miSelectList(Map<String, Object> map) {
			System.out.println( map.get("search_text"));
			System.out.println( map.get("search_type"));
		return session.selectList("miSelectList", map);
	}


}
