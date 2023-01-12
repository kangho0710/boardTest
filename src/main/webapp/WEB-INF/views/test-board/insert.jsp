<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet"> 
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
 <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
</head>
<body>
<table>
		<tr>
			<td>작성자</td>
			<td><input type="text" id="tbWriter" name="writer"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" id="tbTitle" name="subject"></td>
		</tr>
		<tr>
			<td>지역</td>
			<td><select id="tbRegion">
					<option value = "서울">서울</option>
					<option value = "인천">인천</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>취미</td>
			<td><select id="tbCategory">
					<option value = "soccer">축구</option>
					<option value = "baseball">야구</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><textarea class="summernote" id="tbContent" name="memo"></textarea>
			</td>
		</tr>
		<tr>
			<th colspan = "2">
				<button onclick = "insertBoard()">등록</button>
			</th>
		</tr>
	</table>

	
	<script>
		$('.summernote').summernote({
			height:150,
			lang: 'ko-KR',
			focus: true,
			toolbar :[
				['fontname',['fontname']],
				['fontsize',['fontsize']],
				['style',['bold','italic','underline','strikethrough','clear']],
				['color',['forecolor','color']],
				['table',['table']],
				['para',['ul','ol','paragraph']],
				['height',['height']],
				['insert',['picture','link','video']],
				['view',['codeview','fullscreen','help']]
			],
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
		});
	
		function insertBoard(){
			const param = {};
			param.tbWriter = document.querySelector('#tbWriter').value;
			param.tbTitle = document.querySelector('#tbTitle').value;
			param['tbContent'] = document.querySelector('#tbContent').value;
			param.tbRegion = document.querySelector('#tbRegion').value;
			param.tbCategory = document.querySelector('#tbCategory').value;
			
			fetch('/test-board/insert',{
				method:'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
			})
			.then(async function(res){
				if(res.ok){
					return res.json();
				}else{
					const err = await res.text();
					throw new Error(err);
				}
			})
			.then(function(data){
				if(data===1){
					alert('정상등록 되었습니다.');
					location.href='/views/test-board/list';
				}
				
			})
			.catch(function(err){
				alert(err);
			});
		}
	
	</script>

</body>
</html>