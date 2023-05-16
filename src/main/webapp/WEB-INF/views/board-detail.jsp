<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${board.boardTitle}</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(document).ready(function(){
    $('#commentForm').on('click', function(e) {
        e.preventDefault();
        var boardId = ${board.boardId};
        var comment = $('#comment').val();
        $.ajax({
            url: '/board/post/' + boardId + '/comment',
            type: 'POST',
            data: { 'replyContent': comment },
            success: function(response) {
                var newComment = '<div class="border-t border-gray-300 pt-4 mb-4"><p><strong>' + response.userId + '</strong> (' + response.replyDate + ')</p><p>' + response.replyContent + '</p></div>';
                $('#commentList').append(newComment);
                $('#comment').val(''); // clear the textarea
            },
            error: function(error) {
                console.log(error);
            }
        });
    });
});
</script>

</head>
<body class="bg-gray-200 flex items-center justify-center h-screen">
   <div class="bg-white p-10 rounded-lg shadow-lg w-full max-w-screen-lg">
      <div class="mb-10">
         <h2 class="text-2xl font-bold text-gray-800">${board.boardTitle}</h2>
         <div class="text-gray-700 mt-2">
            <span>작성자: ${board.userId}</span>
            <span>작성일: ${board.boardDate}</span>
         </div>
      </div>
      <div class="mb-10">
         <p>${board.boardContent}</p>
      </div>
      <c:if test="${board.userId == login.userId}">
         <div class="flex justify-end space-x-2 mb-10">
            <a href="/springweb/board/post/${board.boardId}/edit" class="bg-yellow-500 text-white px-4 py-2 rounded">글 수정</a>
            <a href="/springweb/board/post/${board.boardId}/delete" class="bg-red-500 text-white px-4 py-2 rounded">글 삭제</a>
         </div>
      </c:if>
      <div class="mb-10">
         <button class="bg-blue-500 text-white px-4 py-2 rounded">추천</button>
         <span>${board.boardLike}</span>
         <button class="bg-red-500 text-white px-4 py-2 rounded ml-2">반대</button>
         <span>${board.boardHate}</span>
      </div>
      <textarea id="comment" name="replyContent" class="w-full p-2 border border-gray-300 rounded mt-1"></textarea>
      <button id="commentForm" class="w-full p-2 bg-blue-500 text-white rounded mt-2">댓글 달기</button>
      <div id="commentList" class="mt-10">
         <h3 class="text-xl font-bold text-gray-800 mb-4">댓글</h3>
            <c:forEach var="reply" items="${replys}">
                <div class="border-t border-gray-300 pt-4 mb-4">
                    <p><strong>${reply.userId}</strong> (${reply.replyDate})</p>
                    <p>${reply.replyContent}</p>
                </div>
            </c:forEach>
        </div>
   </div>
</body>
</html>
