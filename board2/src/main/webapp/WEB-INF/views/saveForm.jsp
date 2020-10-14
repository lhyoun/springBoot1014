<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>

<main>
   <h2 style="text-align: center;">글 작성</h2>
   <br> <br> <br>

   <div style="width: 60%; margin: auto;">
      <input id="title" type="text" style="width: 40%;" placeholder="제목" />
      <br> <br>
      <textarea id="summernote" name="content"></textarea>

      <button onclick="createBoard()">글쓰기 완료</button>

      <!-- <input id="subBtn" type="button" value="글 작성" style="float: right;" onclick="createBoard"/> -->
   </div>


</main>

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
</script>

<script>
function createBoard(){
   let title_el = document.querySelector("#title");
   let content_el = document.querySelector("#summernote");
   let title = title_el.value;
   let content = content_el.value;

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
         alert("등록 성공");
         location.href="/board/list";   
      }else{
         alert("등록 실패");
      }
   });
} 
</script>

<%@include file="layout/footer.jsp"%>