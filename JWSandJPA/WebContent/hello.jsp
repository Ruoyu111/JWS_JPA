<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
	<h1>Hello from JSP</h1>
	<script>
		$(function(){
			alert("Hello from JQuery");
			var site = {id:7,name:"buptSite",latitude:"buptLatitude",longitude:"buptLongitude"};
			
			$.ajax({
				url:"api/site",
				type: "post",
				contentType: "application/json",
				dataType: "json",
				data: JSON.stringify(site),
				success: function(response){
					console.log("yahoo");
				}
			})
		});
	
	</script>
</body>
</html>