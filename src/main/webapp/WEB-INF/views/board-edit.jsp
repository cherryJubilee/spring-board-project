<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>글 수정하기</title>
	<style>
		* {
			box-sizing: border-box;
			margin: 0;
			padding: 0;
		}

		body {
			font-family: Arial, sans-serif;
			background-color: #f5f5f5;
		}

		.container {
			max-width: 800px;
			padding: 20px;
			background-color: white;
			border-radius: 8px;
			box-shadow: 0 4px 6px 0 rgba(0, 0, 0, 0.1);
			margin: 24px auto;
		}

		h2 {
			margin-bottom: 24px;
			color: #333;
		}

		.input-field {
			margin-bottom: 24px;
		}

		.input-field label {
			font-size: 16px;
			margin-bottom: 8px;
			display: block;
			color: #555;
		}

		.input-field input,
		.input-field textarea {
			width: 100%;
			padding: 12px;
			border: 1px solid #ddd;
			border-radius: 4px;
			color: #555;
		}

		.submit-button {
			padding: 12px 24px;
			border: none;
			border-radius: 4px;
			background-color: pink;
			color: white;
			cursor: pointer;
			font-size: 16px;
			font-weight: bold;
		}

		@media screen and (max-width: 480px) {
			.container {
				padding: 10px;
			}
			h2 {
				font-size: 24px;
			}
			.input-field label,
			.input-field input,
			.input-field textarea {
				font-size: 14px;
			}
			.submit-button {
				font-size: 14px;
			}
		}
	</style>
</head>
<body>
	<div class="container">
		<form action="/spring/board/updateBoard/${boardId}" method="post">
			<h1>게시글 수정</h1>
			<br>
			<div class="input-field">
				<label for="boardTitle">제목</label>
				<input type="text" id="boardTitle" name="boardTitle" value="${editboard.boardTitle}">
			</div>
			<div class="input-field">
				<label for="boardContent">내용</label>
				<textarea id="boardContent" name="boardContent">${editboard.boardContent}</textarea>
			</div>
			<div class="input-field">
				<label>작성자: ${editboard.userId}</label>
			</div>
			<div class="input-field">
				<label>날짜: ${editboard.boardDate}</label>
			</div>
			<button type="submit" class="submit-button">수정하기</button>
		</form>
	</div>
</body>
</html>
