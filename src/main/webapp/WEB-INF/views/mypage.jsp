<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Page</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	width: 800px;
	padding: 20px;
	background-color: white;
	border-radius: 8px;
	box-shadow: 0 4px 6px 0 rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	margin-bottom: 24px;
	color: #333;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-top: 12px;
	margin-bottom: 4px;
}

input[type="text"], input[type="password"] {
	padding: 8px;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 14px;
}

button {
	padding: 12px;
	background-color: pink;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #E91E63;
}

.button-container {
	display: flex;
	margin-top: 24px;
}

button[type="submit"], button[type="button"] {
	flex-grow: 1;
	margin-right: 4px;
}

button[type="button"] {
	margin-right: 0;
}
</style>
</head>

<body>

	<div class="container">
		<h2>♡ My Page ♡</h2>
		<form action="update_user" method="post">
		
			<label for="userId">아이디</label> 
			<input type="text" id="userId" name="userId" value="${login.userId}" readonly> 
			
			<label for="userPw">비밀번호 변경</label> 
			<input type="password" id="userPw" name="userPw" required> 
			
			<label for="userName">이름 변경</label> 
			<input type="text" id="userName" name="userName" required>
			
			<div class="button-container">
				<button type="submit">수정하기</button>
				<a href="board" style="text-decoration: none;"><button type="button">게시판으로 돌아가기</button></a>
			</div>
		</form>
	</div>

</body>
</html>
