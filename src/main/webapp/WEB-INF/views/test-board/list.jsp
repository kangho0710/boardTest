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
	<input type = "text" id = "tbTitle" placeholder = "제목">
	<input type = "text" id = "tbContent" placeholder = "내용">
		<button onclick = "getBoardLists()">조회</button>
		
	
	<table class ="table table-striped" border = "1">
		<tr>
			<th>카테고리</th>
			<th>지역</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<tbody id=tBody></tbody>
	</table>
	
	<button onclick="location.href='/views/test-board/insert'">등록</button>
	
	<script>
	function getBoardLists(){
		let param = '?tbTitle=' + document.querySelector('#tbTitle').value;
		param += '&tbContent=' + document.querySelector('#tbContent').value;
		
		fetch('/test-board'+param)
		.then(function(res){
			return res.json();
		}).then(function(data){
			let html = '';
			for(let i = 0; i<data.length; i++){
				const boardList =data[i];
				html += '<tr>';
				html +='<td>' + boardList.tbCategory + '</td>';
				html +='<td>' + boardList.tbRegion + '</td>';
				html += '<td><a href="/views/test-board/view?tbNum=' + boardList.tbNum + '">' + boardList.tbTitle + '</a></td>';
				html +='<td>' + boardList.tbWriter + '</td>';
				html +='<td>' + boardList.tbCnt + '</td>';
				html +='<td>' + boardList.tbCredat + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		})
	}
		window.onload = function(){
			getBoardLists();
		}
	</script>	
</body>
</html>