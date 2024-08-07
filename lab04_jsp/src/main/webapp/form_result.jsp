<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form result</title>
<style>
    <%
    String color = request.getParameter("color");
    String textColor = "";
    switch (color){
    case "r":
        textColor = "crimson";
        break;
    case "g":
        textColor = "darkgreen";
        break;
    case "b":
        textColor = "slateblue";
        break;
    default:
        textColor = "black";
    }
    %>
    
    span#username {
        color: <%= textColor%>;
    }
</style>
</head>
<body>
    <%@ include file = "header.jspf" %>
    
    <h1>폼 양식 제출 결과</h1>
    <%-- JSP 내장 객체: 
        jsp 파일이 java코드(파일)로 변환될 때 _jspService(request,response) 메서드 안에서 
        선언된 지역 변수들. 
        스크립트릿에서 지역 변수를 선언할 때 사용할 수 없는 이름들.
        o. request: 클라이언트에서 서버로 보내는 요청 정보들과 메서드를 가지고 있는 객체.
            -getParameter(), ...
        o. response: JSP에선 거의 사용되지않음. 서버에서 응답을 만들 때 사용되는 객체.
            - setContentType(), sendRedirect(), ...
        o. out: JSP Writer. HTML 코드를 작성 기능을 가지고 있는 객체.
            -write(), print(), ... 
        o. pageContext: JSP 페이지가 유지되는 동안 정보를 저장하기 위한 객체.
        o. session: 세션이 유지되는 동안 정보를 저장하기 위한 객체. (예) 로그인 상태 유지.
        o. application: 웹 애플리케이션이 동작 중에 유지 되는 정보를 저장하기 위한 객체.  
        o. config: 서블릿의 환경 설정 정보를 저장하는 객체.
     --%>
    <%
    String username = request.getParameter("username");
    %>
    <h2>안녕하세요, <span id = "username"><%= username %></span>!</h2> <!-- span은 inline 요소를 선택하는것 그 사이에 있는거에 옵션을 줄 수 있음. -->
    
    <% if(username.equals("admin")){ %>
        <h3>관리자 페이지</h3>
    <% } else{ %>
        <h3>일반 사용자 페이지</h3>
    <% } %>
    
</body>
</html>