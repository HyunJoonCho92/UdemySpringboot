<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	$("a").on('click', function(event){
		//기본동작이벤트처리내장태그
		event.preventDefault();
		//othermemberinform?id=${member.id }
		alert(event.target.innerHTML);
		$.ajax({
			url:'othermemberinform', 
			data:{'id': $(this).attr("id")},
			type:'get',
			dataType: 'json',
			success: function(response){
				alert(response.id);
				$("#inform").html("선택하신 회원 정보입니다<br>");
				$("#inform").append(response.name + "<br>");
				$("#inform").append(response.address + "<br>");
				$("#inform").append("<img src=/upload/" + response.image + " >");
			}
			
			
		});
		
	});
	
	
});
</script>
</head>
<body>
<h1> 전체 회원 정보를 가져옵니다. </h1>
<c:forEach items="${memberlist }" var="member">
${member.id } : ${member.pw } :<a id="${member.id }" href="othermemberinform?id=${member.id }"> ${member.name } </a> : ${member.address } <br> 
</c:forEach>

<h1 id="inform"></h1>
</body>
</html>