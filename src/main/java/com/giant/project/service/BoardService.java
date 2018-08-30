package com.giant.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.giant.project.model.Board;
import com.giant.project.model.Detail;
import com.giant.project.model.Member;

public interface BoardService {

	Member login(Member member);

	int writeViewSelect();

	int temporarilyinsert(Board board);

	ArrayList<Board> getSearchDate(Board board);

	int selectjob(Board board);

	Board postBoard(int post_no);

	ArrayList<Detail> postDetail(int post_no);

	int post_noUpdate(Board board);

	int post_noGiveback(Board board);

	int post_detailinsert(Board board);
	List<Board> list();

	List<Map<String, Object>> miSelectList(Map<String, Object> map);



	
}
