<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<script src="./resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		/* 임시저장 */
		$("#temporarily").on("click",function(){
			var frm = document.payment;
			console.log(frm)
			frm.method = "POST";
			frm.action = "temporarily?Status=1";
			frm.submit();
			
// 			$("#payment").attr("method","post");
// 			$("#payment").attr("action","temporarily");
// 			$("#payment").submit();
		})
		/* 결제 */
		$("#payment_request").on("click",function(){
			var frm = document.payment;
			frm.method = "post";
			frm.action = "payment_request?Status=2";
			frm.submit();
		})
	})
	
	
// 	 $(document).ready(function(){
// 		$("#payment_request").on("click",function(){
// 			var frm = document.payment;
// 			frm.method = "post";
// 			frm.action = "payment_request?Status=2";
// 			frm.submit();
// 		})
// 	}) 
</script>
</head>
<body>
	<div>
		<table>
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
		<form name="payment" id = "payment">
		<input type="hidden" name="mem_id" value="${member.mem_id}">
		<input type="hidden" name="d_job"  value="${member.mem_job }">
		<table>
			<tr>	
				<td>번호 : </td>
				<td>
					<input type="text" name="post_no" id="post_no" value="${post_no }" readonly="readonly">
				</td>
			</tr>
			<tr>	
				<td>작성자 : </td>
				<td><input type="text" value="${member.mem_name}" disabled="disabled"> </td>
			</tr>
			<tr>	
				<td>제목 : </td>
				<td><input type="text" name="subject"> </td>
			</tr>
			<tr>	
				<td>내용 : </td>
				<td><input type="text" name="content"> </td>
			</tr>
			<tr>
				<td colspan="1">
					<input type="button" value="반려">
					<input type="button" id="temporarily" value="임시저장" >
					<input type="button" id="payment_request" value="결제">
				</td>
			</tr>
		</table>
		</form>
	
	</div>

</body>
</html>