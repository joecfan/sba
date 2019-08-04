<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>FSD Course Center</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link
  rel="stylesheet"
  href="https://use.fontawesome.com/releases/v5.9.0/css/all.css"
  integrity="sha384-i1LQnF23gykqWXg6jxC2ZbCbUMxyw5gLZY6UiUS98LYV5unm8GWmfkIS6jqJfb4E"
  crossorigin="anonymous"
/>
<link rel="stylesheet" href="${ctx }/assets/css/layout.css" />
<link rel="stylesheet" href="${ctx }/assets/css/signup.css" />
<script type="text/javascript">
  function changeCaptcha(ctx){
      $(".captcha-image").attr("src", ctx + "/captcha_image");
  }
</script>
</head>
<body>

    <jsp:include page="layout/header.jsp"></jsp:include>

    <div class="container-fluid">
        <div class="row flex-xl-nowrap">
            <div class="col-12 col-md-3 col-xl-2 bd-sidebar">
            
                <jsp:include page="layout/sidemenu.jsp"></jsp:include>
            </div>

            <main class="col-12 col-md-9 col-xl-10 py-md-3 pl-md-5 bd-content" role="main">
		        <form class="form-signup" method="post" action="${ctx }/register">
		            <c:if test="${not empty errorMessge}">
		                 <div class="alert alert-danger" role="alert">${ errorMessge }</div>
		            </c:if>
		            <p>
		                <label for="name">Name</label>
		                <input
		                    type="text" id="name" name="name" class="form-control"
		                    required="" autofocus="" autocomplete="off">
		            </p>
		            <p>
		                <label for="email">Email</label>
		                 <input
		                    type="email" id="email" name="email" class="form-control"
		                    required="" autocomplete="off">
		            </p>
		            <p>
		                <label for="username">Username</label>
		                <input
		                    type="text" id="username" name="username" class="form-control"
		                   required="" autofocus="" autocomplete="off">
		            </p>
		            <p>
		                <label for="password">Password</label>
		                 <input
		                    type="password" id="password" name="password" class="form-control" required="">
		            </p>
		            <p>
		                <label> <img src="${ctx}/captcha_image" onclick="changeCaptcha('${ctx }')" width="80" height="34" class="captcha-image" alt="Captcha Code"/>
                           <a href="javascript:void(0)" class="btn-refresh" onclick="changeCaptcha('${ctx }')"><i class="fas fa-redo"></i></a></label>
		                   <input class="form-control captcha-input" name="kaptcha" placeholder="Enter Captcha" required="" autocomplete="off">
		            </p>
		            <p>
		               <label></label>
		               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                       <button class="btn btn-success" type="submit" > Register</button>
                       <button class="btn btn-light ml-4" type="reset" >Reset</button>
		            </p>
            </div>
            </main>
        </div>

    </div>


</body>
</html>