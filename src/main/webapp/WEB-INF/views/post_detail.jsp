<%@page import="com.giant.project.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="./resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		/* 결제 승인 */
		$("#approval").on("click",function(){
			var frm = document.payment;
			frm.method = "post";
			frm.action = "post_noUpdate";
			frm.submit();
		})
	})
	
	
	$(document).ready(function(){
		/* 결제 반려 */
		$("#giveback").on("click",function(){
			var frm = document.payment;
			frm.method = "post";
			frm.action = "post_noGiveback";
			frm.submit();
		})
	})

</script>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<td>경제 요청 </td>
				<td>과장</td>
				<td>부장</td>
			</tr>
			<tr>	
				<td><input type="checkbox"> </td>
				<td><input type="checkbox"> </td>
				<td><input type="checkbox"> </td>
			</tr>
		</table>
	</div>
	<div>
	<% Member member = (Member)session.getAttribute("member"); %>
		<form name="payment">
		<input type="hidden" name="mem_id" value="${member.mem_id}">
		<input type="hidden" name="status" value="${member.mem_job }"> 
		<table>
			<tr>	
				<td>번호 : </td>
				<td>
					<input type="text" name="post_no" id="post_no" value="${board.post_no }" >
				</td>
			</tr>
			<tr>	
				<td>작성자 : </td>
				<td><input type="text" value="${member.mem_name}" disabled="disabled"> </td>
			</tr>
			<tr>	
				<td>제목 : </td>
				<td><input type="text" name="subject" value="${board.subject }" disabled="disabled"></td>
			</tr>
			<tr>	
				<td>내용 : </td>
				<td><input type="text" name="content" value="${board.content }" disabled="disabled"> </td>
			</tr>
			<tr>
				<td colspan="1">
					<input type="button" id="giveback" value="반려">
					<input type="button" id="approval" value="결제">
				</td>
			</tr>
		</table>
		</form>
	</div>
	
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>결제일</th>
				<th>결제자</th>
				<th>결제상태</th>
			</tr>
			<c:forEach var="detail" items="${list }">
				<tr>
					<td>${detail.d_post_no }</td>
					<td>
					<fmt:formatDate value="${detail.d_upt_date }" pattern="yyyy-MM-dd" /> </td>
					<td>${detail.d_upt_id }</td>
					<td>
						<c:if test="${detail.d_status == 1}">임시저장</c:if>
						<c:if test="${detail.d_status == 2}">결제대기</c:if>
						<c:if test="${detail.d_status == 3}">결제중</c:if>
						<c:if test="${detail.d_status == 4}">결제완료</c:if>
						<c:if test="${detail.d_status == 5}">반려</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>