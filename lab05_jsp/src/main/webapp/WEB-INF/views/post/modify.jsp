<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>lab05</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <c:set var="pageTitle" value="Post Modify" />
        <%-- scope의 기본값은 page(무슨말이지) --%>
        <%@ include file="../fragments/header.jspf"%>

        <main>
            <div class="mt-2 card">
                <div class="card-header">
                    <h2>포스트 수정페이지</h2>
                </div>
                <div class="card-body">
                    <form id="modifyForm">
                        <div class="mt-2">
                            <label for="id" class="form-label">번호</label>
                            <input id="id" class="form-control"
                                name="id" type="text" value="${post.id}"
                                readonly />
                        </div>
                        <div>
                            <label for="title" class="form-label">글제목</label>
                            <input id="title" class="form-control"
                                name="title" type="text"
                                value="${post.title}" />
                        </div>
                        <div>
                            <label for="content" class="form-label">글내용</label>
                            <textarea name="content" id="content"
                                class="form-control"> ${post.content}" </textarea>
                        </div>
                        <div class="mt-2 d-none">
                            <!-- d-none => div 안에있는걸 화면에 제공하지 않겠다. -->
                            <label for="author" class="form-label">작성자</label>
                            <input id="author" class="form-control"
                                type="text" value="${post.author}"
                                readonly />
                            <!-- 수정 할수있을라면 사용자이름이랑 일치하는지 확인할라고 일단 냄겨둠 -->
                        </div>
                        <div>
                            <label for="createdTime" class="form-label">작성
                                시간</label> <input id="createdTime"
                                class="form-control" type="text"
                                value="${post.createdTime}" readonly />
                        </div>
                        <div>
                            <label for="modifiedTime" class="form-label">최종
                                수정 시간</label> <input id="modifiedTime"
                                class="form-control" type="text"
                                value="${post.modifiedTime}" readonly />
                        </div>
                    </form>
                </div>
                <c:if test = "${post.author eq signedInUser}">
                    <div class="card-footer">
                        <button id="btnUpdate"
                            class="btn btn-outline-success">업데이트</button>
                        <!--  수정한거 저장하기 -->
                        <button id="btnDelete"
                            class="btn btn-outline-danger">삭제</button>
                        <!-- 글삭제  -->
                    </div>
                </c:if>
            </div>
        </main>
    </div>


    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <c:url var="post_modify_js" value="js/post_modify.js" />
    <script src="../js/post_modify.js" ${post_modify_js}></script>
</body>
</html>