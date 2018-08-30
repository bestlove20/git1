<%@page import="com.giant.project.model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 리스트</title>
</head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
<script type="text/javascript">
	$(function() {
		  $( "#datepicker1" ).datepicker({
		    dateFormat: 'yy-mm-dd'
		  });
		}); 
	
	$(function() {
		  $( "#datepicker2" ).datepicker({
		    dateFormat: 'yy-mm-dd'
		  });
		});



</script>
<body>
<% Member member = (Member)session.getAttribute("member"); %>   
	<div id="head">
		<%= member.getMem_name() %> 
		${sessionScope.member.mem_name }
		${member.mem_name }(${member.mem_job })
		님 환영합니다.<input type="button" value="로그아웃">
	
	</div>
	<div id="body">
		<div id="body_top">
			<select>
				<option value="1">작성자</option>
				<option value="2">제목</option>
				<option value="3">결제자</option>
			</select>
			<input type="text">
			<select>
				<option value="1">임시저장</option>
				<option value="2">결재대기</option>
				<option value="3">결제중</option>
				<option value="4">결제완료</option>
			</select>
			<br>
			 <input type="text" id="datepicker1"> ~ <input type="text" id="datepicker2">
		</div>
		<div id="body_center">
			<table border="1">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th>결제일</th>
					<th>결제자</th>
					<th>결제상태</th>
				</tr>
			<c:forEach var="board" items="${list }">
				<tr>
					<td>${board.post_no}</td>
					<td>
						${board.mem_id}
					</td>
					<td>
						<a href="post_detail?post_no=${board.post_no}&status=${member.mem_job }">${board.subject}</a>  
					</td>
					<td>
						<fmt:formatDate value="${board.reg_date}" pattern="yyy-MM-dd"/>
					</td>
					<td>
						<fmt:formatDate value="${board.upt_date}" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						${board.upt_name}
					</td>	
					<td>
					<c:if test="${board.status == 1}">임시저장</c:if>
					<c:if test="${board.status == 2}">결제대기</c:if>
					<c:if test="${board.status == 3}">결제중</c:if>
					<c:if test="${board.status == 4}">결제완료</c:if>
					<c:if test="${board.status == 5}">반려</c:if>
					</td>				
				</tr>
			</c:forEach>
				
				
			</table>																							
			<input type="button" value="글쓰기" onclick="javascript:location.href = 'writeView?mem_name=${member.mem_name }&mem_id=${member.mem_id }&mem_job=${member.mem_job }'">
		</div>
	
	
	</div>
</body>
</html>