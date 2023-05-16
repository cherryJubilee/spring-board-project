<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 작성</title>
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

input[type="text"], textarea {
	padding: 8px;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 14px;
}

input[type="file"] {
	border: none;
}

button {
	margin-top: 24px;
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
</style>
</head>

<body>

	<div class="container">
		<h2>게시글 작성</h2>
		<form action="submit_board" method="post">
			<label for="boardTitle">글제목</label> <input type="text"
				id="boardTitle" name="boardTitle" required> <label
				for="boardContent">글내용</label>
			<textarea id="boardContent" name="boardContent" rows="8" required></textarea>

			<label for="boardImg">이미지 업로드</label> <input type="file"
				id="boardImg" name="boardImg">
<input type="hidden"
				id="userId" name="userId" value="${login.userId}"> 
			<button type="submit">글작성</button>
		</form>
	</div>

</body>
</html>
