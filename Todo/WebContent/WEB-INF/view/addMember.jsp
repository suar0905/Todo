<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#addBtn').click(function(){
			if($('#memberId').val() == '') {
				alert('아이디를 입력하세요');
				return;
			}
			if($('#memberPw').val() == '') {
				alert('비밀번호를 입력하세요');
				return;
			}
			
			$('#addForm').submit();
		});
	});
</script>
</head>
<body>
	<body style="background-image: url('images/sky.jpg'); background-size: 100% 120%;">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">회원가입</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-5">
					<div class="login-wrap p-4 p-md-5">
		      			<div class="icon d-flex align-items-center justify-content-center">
		      				<span><i class="fas fa-user-plus"></i></span>
		      			</div>
		      			<h3 class="text-center mb-4">Sign Up</h3>
						<form class="login-form" id="addForm" method="post" action="${pageContext.request.contextPath}/addMember">
				      		<div class="form-group">
				      			<input type="text" class="form-control rounded-left" placeholder="Username" id="memberId" name="memberId">
				      		</div>
				            <div class="form-group d-flex">
				              <input type="password" class="form-control rounded-left" placeholder="Password" id="memberPw" name="memberPw">
				            </div>
				            <div class="form-group">
				            	<button type="button" class="form-control btn btn-primary rounded submit px-3" id="addBtn" onclick="button()">Add</button>
				            </div>
			            	<div class="form-group" style="text-align: center;">
								<div>
									<button class="btn btn-outline-light text-primary" type="reset">초기화</button>
									<a class="btn btn-outline-light text-primary" href="${pageContext.request.contextPath}/login">로그인</a>
								</div>
			            	</div>
			          </form>
	        		</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>