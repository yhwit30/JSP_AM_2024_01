<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
int cPage = (int) request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 삭제</title>
</head>
<body>


	<%-- <h2><%=articleRow.get("id")%>
		번 게시물이 삭제되었습니다.
	</h2>
	<a href="list?page=<%=cPage%>">목록으로 이동</a> --%>

<form name="hiddenForm" method="POST" action="doDelete">
		<input type="hidden" value="<%=articleRow.get("id")%>" name="id" />
		<input type="hidden" value="<%=cPage%>" name="page" />
	</form>


<script>
document.hiddenForm.submit();
	</script>



</body>
</html>