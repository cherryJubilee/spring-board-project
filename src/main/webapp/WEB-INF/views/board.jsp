<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, my.test.spring.board.vo.BoardVO"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판</title>
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

.wrapper {
	display: flex;
	height: 100vh;
}

.sidebar {
	background-color: pink;
	width: 200px;
	padding: 20px 0;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.sidebar a {
	color: black;
	text-decoration: none;
	padding: 12px;
	margin-bottom: 4px;
	width: 100%;
	text-align: center;
}

.sidebar a:hover {
	background-color: #E91E63;
}

.container {
	flex: 1;
	padding: 20px;
	background-color: white;
	border-radius: 8px;
	box-shadow: 0 4px 6px 0 rgba(0, 0, 0, 0.1);
	margin: 24px;
}

h2 {
	text-align: center;
	margin-bottom: 24px;
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 24px;
}

th, td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: pink;
}

a.board-title {
  color: #E91E63;
  text-decoration: none;
  transition: 0.3s;
}

a.board-title:hover {
  color: #C2185B;
  text-decoration: underline;
}


</style>
</head>

<body>

	<div class="wrapper">
		<div class="sidebar">
			<a href="mypage">♡ My Page ♡</a>
			<a href="create">☆ 게시글 작성 ☆</a>
		</div>
		
		<div class="container">
			<h2>게시판</h2>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성자</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td>${board.boardId}</td>
							<td><a class="board-title" href="detail/${board.boardId}">${board.boardTitle}</a></td>
							<td>${board.boardContent}</td>
							<td>${board.userId}</td>
							<td>${board.boardDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
