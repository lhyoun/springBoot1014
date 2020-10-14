<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<title>글쓰기</title>


</head>





<body>
<h2 style="text-align: center;">글 작성</h2><br><br><br>

<div style="width: 60%; margin: auto;">
		<input id="title" type="text" style="width: 40%;" placeholder="제목"/>
		<br><br> 
		<textarea id="summernote" name="content"></textarea>
		
		<button onclick="createBoard">글쓰기 완료</button>
		
		<!-- <input id="subBtn" type="button" value="글 작성" style="float: right;" onclick="createBoard"/> -->
</div>
<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	});

function createBoard(id){
	let title_el = document.querySelector("#title");
	let content_el = document.querySelector("#summernote");
	let title = title_el.value;
	let content = content_el.value;
alert("asd");
	let board = {
			title: title,
			content: content
	};
	
	fetch("/board/save",{
		method: "post",
		headers: {
			'Content-Type': 'application/json; charset=utf-8',
		},
		body: JSON.stringify(board)
	}).then(res=> res.text())
	.then(res=>{
		if(res=="ok"){
			alert("삭제 성공");
			location.href="/board/list";	
		}else{
			alert("삭제 실패");
		}
	});
}
</script>
</body>
</html>