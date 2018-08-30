package com.giant.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giant.project.dao.BoardDao;
import com.giant.project.service.BoardService;
import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.PlatformResponse;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;
import com.tobesoft.platform.data.Variant;

@Controller
public class MiController {
	
//	@Resource(name="boardService" )
//	private BoardService bs;
	@Autowired
	private BoardService bs;
	

	
	@RequestMapping(value = "boardSelect")
	public void boardSelect(HttpServletRequest request, HttpServletResponse response ) throws IOException {
		// uri에 직접 get방식으로 param값 지정했을 경우
		// request.getParameter("");
	    // response.sendRedirect(arg0);
		
		VariableList vl = new VariableList();
		DatasetList dl = new DatasetList();
		
		PlatformRequest req = new PlatformRequest(request, "utf-8");
		req.receiveData();
		// callback앞 변수지정시 값 가져오는 방법
/*		
		vl = req.getVariableList();
//		dataset으로 묶지 않고 get이나 post 방식으로 데이터를 가져올때 사용한다.
		String search_text = vl.getValueAsString("search_text");
		System.out.println("search_text = "+search_text);
		String pw = vl.getValueAsString("pw");
	*/	
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		마이플랫폼 dataset에 담겨있는 값 가져오는 방법
		System.out.println("마이플랫폼 dataset에 담겨있는 값 가져오기");
		dl = req.getDatasetList();
		Dataset inputDs = dl.getDataset("searchDs");
		/*for (int i = 0; i < inputDs.getRowCount(); i++) {
			System.out.println("데이터 셋 데이터 type = " + inputDs.getColumn(i, "search_type"));
			System.out.println("데이터 셋 데이터 text = " + inputDs.getColumn(i, "search_text"));
			
			
			String search_text =  inputDs.getColumn(i, "search_text").toString();
			String search_type =  inputDs.getColumn(i, "search_type").toString();
			map.put("search_text",  inputDs.getColumn(i, "search_text").toString());
			map.put("search_type", inputDs.getColumn(i, "search_type").toString());
			System.out.println("map type = " + map.get("search_type"));
			System.out.println("map text = " +inputDs.getColumn(i, "search_text").toString());
		}*/
//		데이터를 한번 가져올경우 구지 포문을 돌릴 필요가 없다 
		String search_type = "";
		if (inputDs != null) {   // inputDs (dataset) null 경우 처리 (조회와 검색 충돌 방지)
			System.out.println("데이터 셋 데이터 type = " + inputDs.getColumn(0, "search_type"));
			System.out.println("데이터 셋 데이터 text = " + inputDs.getColumn(0, "search_text"));
			search_type = inputDs.getColumn(0, "search_type").toString();
			if(search_type.equals("전체")){
				search_type = "all";
				System.out.println("dddddddd = "+ search_type);
			} else if (search_type.equals("제목")) {
				search_type = "subject";
			} else if (search_type.equals("제목or내용")) {
				search_type = "subject_content";
			} else if (search_type.equals("닉네임")) {
				search_type = "name";
			}
			
			map.put("search_text",  inputDs.getColumn(0, "search_text").toString());
			map.put("search_type", search_type);
			
			map.put("search_text",  inputDs.getColumn(0, "search_text").toString());
			map.put("search_type", search_type);
			System.out.println("map type = " + map.get("search_type"));
			System.out.println("map text = " +inputDs.getColumn(0, "search_text").toString());
		}
		
		
		
		
		
//		String search_text =  inputDs.getColumn(i, "search_text").toString();
//		String search_type =  inputDs.getColumn(i, "search_type").toString();
		
		
/*		System.out.println("search_type = "+ map.get("search_type"));
		if(map.get("search_type")==null || map.get("search_type")== ""){
			map.put("search_type", null);
		}*/
		
		
		
//		리스트 setect
		list = bs.miSelectList(map);
		Dataset ds = new Dataset("javaDataSet"); // dataset을 생성해주고 javadataset이라는 데이터셋 변수명을 지정해준다
		ds.addColumn("post_no", ColumnInfo.COLUMN_TYPE_INT , 100);
		ds.addColumn("mem_id", ColumnInfo.COLUMN_TYPE_STRING , 100);
		ds.addColumn("subject", ColumnInfo.COLUMN_TYPE_STRING , 100);
		ds.addColumn("content", ColumnInfo.COLUMN_TYPE_STRING , 1000);
		ds.addColumn("reg_date", ColumnInfo.COLUMN_TYPE_DATE , 100);
		ds.addColumn("upt_id", ColumnInfo.COLUMN_TYPE_STRING , 100);
		ds.addColumn("upt_date", ColumnInfo.COLUMN_TYPE_DATE , 100);
		ds.addColumn("status", ColumnInfo.COLUMN_TYPE_STRING , 100);
		
		for (int i = 0; i < list.size(); i++) {
			int row = ds.appendRow();
			String post_no = list.get(i).get("POST_NO").toString();
			String mem_id = list.get(i).get("MEM_ID").toString();
			String subject = list.get(i).get("SUBJECT").toString();
			String content = list.get(i).get("CONTENT").toString();            // toString은 값을 불러온다.
			String reg_date = list.get(i).get("REG_DATE").toString();
			String upt_id = (String) list.get(i).get("UPT_ID");                // 값이 널값이 들어가 있는경우 toString대신 (String)를 사용
			String upt_date = (String) list.get(i).get("UPT_DATE");
			String status = list.get(i).get("STATUS").toString();
			
			if (status.equals("1")) {
				status = "임시저장";
			} else if(status.equals("2")) {
				status = "결제대기";
			} else if(status.equals("3")) {
				status = "결제중";
			} else if(status.equals("4")) {
				status = "결제완료";
			} else if(status.equals("5")) {
				status = "결제완료";
			}
			ds.setColumn(row, "post_no", post_no);
			ds.setColumn(row, "mem_id", mem_id);
			ds.setColumn(row, "subject", subject);
			ds.setColumn(row, "content", content);
			ds.setColumn(row, "reg_date", reg_date);
			ds.setColumn(row, "upt_id", upt_id);
			ds.setColumn(row, "upt_date", upt_date);
			ds.setColumn(row, "status", status);
		}
			dl.addDataset(ds);
			PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.JSP_XML, "UTF-8");
			pRes.sendData(vl, dl);
	}
}



/*
 * 
function Button0_OnClick(obj)
{
	Transaction("sava", "http://localhost:8181/kdh/boardSelect", "", "datalist=javaDataSet" , "", "fanCallback");
	//     트랜젝션 변수명 , "url주소" , "마이플랫폼에서 데이터를 전송할때, "스프링에서 데이터를 가져올때", "post방식처럼 데이터를 전송할때" "데이터를 전송받고 결과"
}

function Button1_OnClick(obj)
{
	// search_text의 text 값을 search_text에 담는다
	var search_text = search_text.Text;
	var search_type = search_type.Value;
	Alert(search_text);
	Alert(search_type);
	// searchform (dataset id)의 로우를 추가(생성)한다. 로우를 추가안할시 set컬럼을 담을수(사용할수)없다
	// searchform.AddRow();
	// 생성한 로우의 컬럼에 추가(담는다)한다. (로우넘버 or 로우명, 컬럼명, 담을 값)
	searchform.SetColumn(0, "search_text", search_text);
	searchform.SetColumn(0, "search_type", search_type);
	// searchform에 담긴 데이터셋을 java의 dataset에 담는다 ( searchDs=searchform ) 담는 순서중요!!!
	
	Transaction("search", "http://localhost:8181/kdh/boardSelect", "searchDs=searchform", "datalist=javaDataSet" , "search_text="+search_text, "fanCallback");
}


function fanCallback(){
	Alert("조회성공");
	// 다른 폼으로 이동 go
	//go("login");
	
	// 창 오픈 
	// Open("join", "", -1, -1, "taskbar=true resize=true", -1, -1);
}
 * */

