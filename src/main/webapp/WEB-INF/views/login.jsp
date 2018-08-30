<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="./resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#submit").on("click",function(){
			var id = $("#mem_id").val(); 
			var pw = $("#mem_pw").val();
			if(id == ""){
				alert("아이디를 입력해주세요")
				$("#mem_id").focus();
			} else if(pw == ""){
				alert("비밀번호를 입력해주세요")
				$("#mem_pw").focus();
			} else {
				var frm = document.login;
				frm.method = "post";
				frm.action = "login";
				frm.submit();
			}
		})
	})
	</script>
</head>
<body>
	<div align="center">
		Login
		<form name="login" id="login" method="post">
		<table>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name="mem_id" id="mem_id" placeholder = "아이디를 입력하세요"> </td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td> <input type="password" name="mem_pw" id="mem_pw"> </td>
			</tr>
		</table>
		</form>
				 <input type="button" id="submit" value="로그인"> 
	</div>
	
	<div>
		<a href="test">엑셀</a>
	</div>
</body>
</html>