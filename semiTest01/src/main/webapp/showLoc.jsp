<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.sist.vo.LocationVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<h2 class="skip">- 관심 지역 관리 -</h2>
	<%
	ArrayList<String> provinces 
	= (ArrayList<String>)request.getAttribute("provinces");
	HashMap<String,ArrayList<String>> districts 
	= (HashMap<String,ArrayList<String>>)request.getAttribute("districts");
	HashMap<String,ArrayList<String>> dongs 
	= (HashMap<String,ArrayList<String>>)request.getAttribute("dongs");
	
	%>
			<fieldset>
			<%for(String province : provinces){ %>
			<div>
			<%=province %>
					<%for(String district : districts.get(province)){ %>
					<div>
					<%=district %>
						<%for(String dong : dongs.get(district)){%>
						<div>
						<%=dong %>
						</div>
						<%} %>
					</div>
					<%} %>
			</div>
			<%} %>
			</fieldset>
	<script>

	</script>
</body>
</html>