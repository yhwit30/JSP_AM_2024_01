<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
int limit = Integer.parseInt(request.getParameter("limit"));
String inputColor = request.getParameter("color");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ���</title>
</head>
<body>


	<h1>
		==<%
	out.print(dan);
	%>��==
	</h1>

	<h1>
		==<%=dan%>��==
	</h1>


	<%
	for (int i = 1; i <= limit; i++) {
	%>
	<div style="color: <%=inputColor %>"><%=dan%>
		*
		<%=i%>
		=
		<%=dan * i%>
	</div>
	<%
	}
	%>




</body>
</html>