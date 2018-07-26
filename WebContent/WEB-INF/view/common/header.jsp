<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8" />
	<title>main</title>
	<link rel="stylesheet" href="${css}/style.css" />
	<script src="${js}/app.js">
	</script>
	
	
	
	
<%--  	var Common = new function Common(){
		this.move = function (domain, action, page){
 			//console.log('클릭 테스트 콘솔 성공!! ${context}');
			//alert('클릭 테스트 성공!! ${context}'); 
			location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
		}
	} 
	와
	var common = new Common(); 이 합쳐진거
	
	
	
 	var Member = function (){
 		//memId, ssn, name, roll, teamId, password, age; 
		this.loginValidation = function (){
			return '유효성체크 하는 중';
		}
	} 
	 var common = new (function (){
		this.move = function (x, y, z){
						location.href = "${context}/"
						+x
						+".do?action="+y
						+"&page="+z;
					}
				});
	var mem = new (function (){
		var memId, ssn, password;  //로 유효성 체크를 해보자. validation. 여기 들어온 값이 기본적인 기준을 통과하느냐 마느냐.
		this.setMemId = function(x){
			this.memId = x;
		}
		this.setSsn = function(y){
			this.ssn = y;
		}
		this.setPassword = function(z){
			this.password = z;
		}
		this.getMemId = function(){
			return this.memId;
		}
		this.getSsn = function(){
			return this.ssn;
		}
		this.getPassword = function(){
			return this.password;
		}
		this.loginValidation = function (){
			var ok = false;
			if(this.memId===""){
				alert( "Please provide your id!" );
			}else if(this.password===""){
				alert( "Please provide your pass!" );
			}else{
				ok=ture;
			}
			return ok;
		}
		this.joinValidation = function(){
			if(this.memId===""){
				alert( "Please provide your id!" );
			}else if(this.password===""){
				alert( "Please provide your pass!" );
			}else{
				
			}
		}
	});  --%>

</head>