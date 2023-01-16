<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/import.jsp"%>

<style>
	.container{
		margin-top: 10px;
	}
  #btn{
	float: right;
	margin-top: 10px;
  }

  #comment{
	padding-top: 10px;
  }


</style>

</head>
<body>
<div>

<div class="container">
			<div class="card">
				<div class="card-body">
					<p class="card-text"> 
						<small class="text-muted" id="tbWriter"></small><!--글쓴이-->
					</p>
					<h5 class="card-title"></h5> <!--제목--> 
					<span class="card-text"> 
						<small class="text-muted" id="tbCategory"></small><!--카테고리-->
					</span>
			<span class="card-text"> 
				<small class="text-muted" id="tbCnt"></small><!--조회수-->
			</span>
			<p class="card-text"> 
				<small class="text-muted" id="tbModdat"></small><!--날짜-->
			</p>
			<p class="card-text" id="tbContent"></p><!--내용-->
		</div>
	</div>
	
	<div id="btn"> 
		<button class="btn btn-primary" onclick = "location.href = '/views/test-board/update?tbNum=${param.tbNum}'">수정</button>
		<button class="btn btn-primary" onclick = "deleteTestBoard()">삭제</button>
	</div>
	
	<div class="input-group" id="comment">
		<span class="input-group-text">댓글</span>
		<textarea class="form-control" aria-label="With textarea"></textarea>
	  </div>
</div>
	
</div>

	
	<!-- <div id = "btnDiv">
		<button onclick = "location.href = '/views/test-board/update?tbNum=${param.tbNum}'">수정</button>
		<button onclick = "deleteTestBoard()">삭제</button>
	</div> -->
	
	
	<!-- <input type = "text" id = "bcWriter" placeholder ="작성자">
	<input type = "text" id = "bcContent" placeholder ="내용">
	<button onclick = "insertComment()">댓글 작성</button> -->



	<script>
		window.onload = function(){
			fetch('/test-board/${param.tbNum}')
			.then(function(res){
				return res.json();
			})
			.then(function(boardInfo){
				console.log(boardInfo)
				document.querySelector('#tbCnt').innerHTML = boardInfo.tbCnt;
				document.querySelector('#tbCategory').innerHTML = boardInfo.tbCategory;
				document.querySelector('#tbWriter').innerHTML = boardInfo.tbWriter;
				document.querySelector('.card-title').innerHTML = boardInfo.tbTitle;
				document.querySelector('#tbModdat').innerHTML = boardInfo.tbModdat;
				document.querySelector('#tbContent').innerHTML = boardInfo.tbContent;
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