<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
이것은 소리없느 ㄴ아우성!!!
<%
  // 2개의 숫자를 Query String으로 받아서
  // 합한 값을 출력
  String num1 = request.getParameter("num1");
  String num2 = request.getParameter("num2");
	
  // 2. 로직처리(DB처리 포함한)
  int n1 = new Integer(num1);
  int n2 = new Integer(num2);
  int result = n1+n2;	

%>
자 그러면 출력 값은 <%= result %> 에요
저기 위해 자바 코드가 나올 수 있어요
</body>
</html>