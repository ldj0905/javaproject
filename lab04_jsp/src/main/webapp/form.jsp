<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
    <%@ include file = "header.jspf" %>
    <main>
        <h1>Form</h1>
        <form method="get" action ="form_result.jsp">
            <!--아이디나 패스워드 숫자 같은거 입력받아서 서버로 보내주는 역할하는게 form -->
            <div>
                <input type="text" name="username"placeholder="사용자 이름을 넣으세요" required autofocus />
            </div>
            
            <div>
                <select name = "color">
                    <option value = "r">빨강</option>
                    <option value = "b">파랑</option>
                    <option value = "g">초록</option>
                </select>
            </div>
            <div>
                <input type = "submit" value="제출"/>
            </div>
        </form>
    </main>
</body>
</html>