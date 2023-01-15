<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/import.jsp"%>
</head>
<body>
	<div id = "rDiv"></div>
	
	<div id = "btnDiv">
		<button onclick = "location.href = '/views/test-board/update?tbNum=${param.tbNum}'">수정</button>
		<button onclick = "deleteTestBoard()">삭제</button>
	</div>
	
	
	<input type = "text" id = "bcWriter" placeholder ="작성자">
	<input type = "text" id = "bcContent" placeholder ="내용">
	<button onclick = "insertComment()">댓글 작성</button>



	<script>
		window.onload = function(){
			fetch('/test-board/${param.tbNum}')
			.then(function(res){
				return res.json();
			})
			.then(function(boardInfo){
				console.log(boardInfo)
				let html = '';
				html += '번호 :' + boardInfo.tbNum + '<br>';
				html += '제목 :' + boardInfo.tbTitle + '<br>';
				html += '작성자 :' + boardInfo.tbWriter + '<br>';
				html += '카테고리 :' + boardInfo.tbCategory + '<br>';
				html += '지역 :' + boardInfo.tbRegion + '<br>';
				html += '내용 :' + boardInfo.tbContent + '<br>';
				document.querySelector('#rDiv').innerHTML = html;
				
			});
			
		}
		
		function insertComment(){
			let param ={};
			param.bcWriter = document.querySelector('#bcWriter').value;
			param.bcContent = document.querySelector('#bcContent').value;
			
			fetch('/board-comment',{
				method : 'POST',
				headers :{
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data===1){
					alert("작성완료");
				} else{
					alert('작성실패');
				}
			})
		}
		
		
		function deleteTestBoard(){
			fetch('/test-board/${param.tbNum}',{
				method:'DELETE'
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data===1){
					alert('삭제완료');
					location.href = '/views/test-board/list';
				}
			});
		}
		
		
		
	</script>
</body>
</html>