<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery를 이용한 Ajax 테스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%--************************************************************************
	* Ajax의 주요 속성
 	- url : 데이터를 전송할 URL(필수로 작성!!)
 	- accept : 파라미터의 타입을 설정(사용자 특화 된 파라미터 타입 설정 가능)
 	- async : 서버와의 비동기 처리 방식 설정 여부(기본값 true)
 	- beforeSend : ajax 요청을 하기 전 실행되는 이벤트 callback 함수(데이터 가공 및 header 관련 설정)
 	- cache : 요청 및 결과값을 scope에서 갖고 있지 않도록 하는 것 (기본값 true)
 	- complete : 요청 완료 후 실행되는 메소드(성공, 에러 이 후에 무조건 실행)
 	- contents : JQuery에서 response의 데이터를 파싱하는 방식 정의
 	- contentType : request의 데이터 인코딩 방식 정의(보내는 측의 데이터 인코딩)
 	- context : ajax 메소드 내 모든 영역에서 파싱 방식 정의
 	- crossDomain : 타 도메인 호출 가능 여부 설정(기본값 false)
 	- data : 요청 parameter 설정
 	- dataFilter : response를 받았을 때 정상적인 값을 return 할 수 있도록 데이터와 데이터 타입 설정
 	- dataType : 서버에서 response로 오는 데이터의 데이터 형 설정, 값이 없다면 스마트하게 판단함
 				 xml - 트리 형태의 데이터 구조
 				 json - 맵 형식의 데이터 구조(일반적인 데이터 구조)
 				 script - javascript 및 일반 String 형태 데이터
 				 html - html 태그 자체를 return 하는 방식
 				 text - String 데이터
 	- error : ajax 통신에 실패 했을 때 호출되는 이벤트 핸들러
 	- global : 기본 이벤트 사용 여부(ajaxStart, ajaxStop)(버퍼링 같이 시작과 끝을 나타낼 때, 선처리 작업)
 	- method : 서버 요청 방식(GET, POST, PUT)
 	- password : 서버에 접속 권한(비밀번호)이 필요한 경우
 	- processData : 서버로 보내는 값에 대한 형태 설정 여부(기본 데이터를 원하는 경우 false설정)
 	- success : ajax 통신에 성공했을 때 호출될 이벤트 핸들러
 	- timeout : 서버 요청 시 응답 대기 시간(milisecond)
 	
 	[참고] API:http://api.jquery.com/jquery.ajax/

 	******************************************************************************************* --%>

	<h1 align="center">jQuery를 이용한 Ajax 테스트</h1>
	<h3>1. 버튼 클릭시 get 방식으로 서버 데이터 전송 및 응답</h3>
	
	입력 : 
	<input type="text" id="input1">
	<button id="btn1">전송</button>
	
	응답 :
	<input type="text" id="output1" style="width: 300px;" readonly>
	
	<script>
		$(function() {
			// 1. 버튼 클릭시 get 방식으로 서버 데이터 전송 및 응답
			$('#btn1').click(function() {
				
				const input = $('#input1').val();
				$.ajax({
					// url : 데이터를 전송할 url(필수)
					url : "jqTest1.do",
	
					// data : 요청시 전달할 파라미터 설정
					data : {
						// key : value 값으로 작성
						input : input
					},
					
					// type : 전송방식 (get / post)
					type : 'get',
	
					// success : ajax 통신 성공시 처리할 함수를 지정하는 속성
					success : function(result) {
						// 파라미터는 임의대로 지정 가능
						// 성공했을 시 결과값
						console.log("ajax 통신 성공");
						$('#output1').val(result);
					},
					
					// error : 통신 실패시 처리할 함수를 지정하는 속성
					error : function() {
						console.log("ajax 통신 실패");
					},
					
					// complete : 통신여부와 상관없이 실행
					complete : function() {
						console.log("무조건 호출");
					}
				});
				
			});
		});
	</script>
	
	<%-- /////////////////////////////////////////////////////////////////////////////// --%>
	
	<h3>2. 버튼 클릭시 post 방식으로 서버 데이터 전송 및 응답</h3>
	
	입력 : 
	<input type="text" id="input2">
	<button id="btn2">전송</button>
	
	응답 :
	<input type="text" id="output2" style="width: 300px;" readonly>
	
	<script>
		$(function() {
			// 1. 버튼 클릭시 get 방식으로 서버 데이터 전송 및 응답
			$('#btn2').click(function() {
				
				const input = $('#input2').val();
				$.ajax({
					// url : 데이터를 전송할 url(필수)
					url : "jqTest2.do",
	
					// data : 요청시 전달할 파라미터 설정
					data : {
						// key : value 값으로 작성
						input : input
					},
					
					// type : 전송방식 (get / post)
					type : 'post',
	
					// success : ajax 통신 성공시 처리할 함수를 지정하는 속성
					success : function(result) {
						// 파라미터는 임의대로 지정 가능
						// 성공했을 시 결과값
						console.log("ajax 통신 성공");
						$('#output2').val(result);
					},
					
					// error : 통신 실패시 처리할 함수를 지정하는 속성
					error : function(e) {
						console.log(e);
					}
				});
				
			});
		});
	</script>
	
	<%-- /////////////////////////////////////////////////////////////////////////////// --%>
	
	<h3>3. 버튼 클릭시 post 방식으로 서버에 여러개의 데이터 전송 및 응답</h3>
	
	입력 : 
	<input type="text" id="input3_1">
	나이 : 
	<input type="text" id="input3_2">
	<button id="btn3">전송</button>
	
	응답 :
	<input type="text" id="output3" style="width: 300px;" readonly>
	
	<script>
		$(function() {
			$('#btn3').click(function() {
				const input3_1 = $('#input3_1').val();
				const input3_2 = $('#input3_2').val();
				
				$.ajax({
					url : 'jqTest3.do',
					data : {
						name : input3_1,
						age : input3_2
					},
					type : 'post',
					success : function(result) {
						$('#output3').val(result);
					},
					error : function() {
						$('#output3').val('ajax 통신 실패');
					}
				});
			});
		});
	</script>
	
	<%-- /////////////////////////////////////////////////////////////////////////////// --%>
	
	<h3>4. 서버로 기본형 데이터 전송 후, 응답 객체 (object) 받기</h3>
	
	회원 번호 입력 :
	<input type="text" id="input4">
	<button id="btn4">조회</button>
	<textarea id="textArea4" rows="4" cols="30"></textarea>
	
	<script>
		$(function() {
			$('#btn4').click(function() {
				const input = $('#input4').val();
				
				$.ajax({
					url : 'jqTest4.do',
					data : {
						input : input
					},
					type : 'get',
					dataType : 'json',
					success : function(obj) {
						console.log(obj);
					},
					error : function() {
						$('#textArea4').val('ajax 통신 실패');
					}
				});
			});
		});
	</script>
	
	<h3>5. 서버로 기본형 데이터 전송 후, 응답을 리스트 형태로 받기</h3>
	
	<h4>선택한 성별을 가진 모든 회원정보를 가지고 오기</h4>
	성별 :
	남 <input type="radio" name="chk_gender5" value="남" checked>
	여 <input type="radio" name="chk_gender5" value="여">
	<button id="btn5">조회</button>
	<textarea id="textArea5" rows="5" cols="30"></textarea>
	
	<script>
		$(function() {
			$("#btn5").click(function() {
				const gen = $('input[name="chk_gender5"]:checked').val();
				
				console.log(gen);
				$.ajax({
					url : "jqTest5.do",
					data : {
						gender : gen
					},
					type: "get",
					success : function(list) {
						
						console.log(list);
						let result = "";
						$.each(list, function(i) {
							result += list[i].no + " / "
								+ list[i].name + " / "
								+ list[i].age + " / "
								+ list[i].gender + " \n";
						});
						
						$("#textArea5").val(result);
					},
					error : function(e) {
						$("#textArea5").val("ajax 통신 실패");
					}
				});
			});
		});
	</script>
	
	<h3>6.서버로 데이터 전송후 , 응답을 맵(map)형태로 받아서 테이블에 출력하기</h3>
	<h4>조회하고자 하는 회원의 이름 키워드를 입력해서 조회되는 회원들 정보와 전달된 키워드를 받아오기 </h4>
	
	
	이름<input type="text" id="input6" width=300>
	<button id="btn6">검색</button>
	<table id="memberTable6" border="1" style="text-align:center">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	
	
	</table>
	<script>
	
		$(function() {
			$("#btn6").click(function() {
				const input = $('#input6').val();
				
				$.ajax({
					url : "jqTest6.do",
					data: {
						keyword : input
					},
					type : "get",
					success : function(map) {
						console.log(map);	
						console.log(map["jArr"]);
						
						const $tableBody = $("#memberTable6 tbody");
						
						$tableBody.html("");
						$.each(map["jArr"], function(index, value) {
							console.log(value);
							
							const $tr = $("<tr>");
							const $noTd = $("<td>").text(value.no); // <td>1</td>
							const $nameTd = $("<td>").text(value.name); // <td>1</td>
							const $ageTd = $("<td>").text(value.age); // <td>1</td>
							const $genTd = $("<td>").text(value.gender); // <td>1</td>
							
							$tr.append($noTd);
							$tr.append($nameTd);
							$tr.append($ageTd);
							$tr.append($genTd);

							$tableBody.append($tr);
						});
					},
					error : function(e) {
						console.log("ajax 통신 실패");
					}
				});
			});			
		});
	
	</script>
	
	<h3>7.Gson을 이용한 List 반환</h3>
	<button id="gbtn">list 가져오기</button>
	<textarea id="textArea7" rows="10" cols="30"></textarea>
	
	<script>
		$(function() {
			$('#gbtn').click(function() {
				$.ajax({
					url : "jqTest7.do",
					type : "get",
					success : function(list) {
						console.log(list);
						let result = "";
						$.each(list, function(i) {
							result += list[i].no + " / "
								+ list[i].name + " / "
								+ list[i].age + " / "
								+ list[i].gender + " \n";
						});
						
						$("#textArea7").val(result);
					},
					error : function(e) {
						$("#textArea7").val("ajax 통신 실패");
					}
				});
			});
		});
	</script>
</body>
</html>