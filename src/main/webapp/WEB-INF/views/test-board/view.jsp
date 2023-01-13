<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "rDiv"></div>
	<div id = "btnDiv">
		<button onclick = "location.href = '/views/test-board/update?tbNum=${param.tbNum}'">수정</button>
		<button onclick = "deleteTestBoard()">삭제</button>
	</div>
	
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
		
		function deleteBoardInfo(){
			const spNum = '${param.tbNum}'
			fetch('/board-infos/${param.tbNum}',{
				method:'DELETE'
			})
			.then(function(res){
				return res.json();
			})
			.then(function(data){
				if(data===1){
					alert('삭제완료');
					location.href = '/views/board-info/list';
				}
			});
		}
		
		
	</script>
</body>
</html>