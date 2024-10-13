<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>TODO List</title>
    <link rel="stylesheet" type="text/css" href="/css/todo.css" />
  </head>
  <body>
    <table class="table">
      <thead>
        <tr>
          <th class="th">번호</th>
          <th class="th">상태</th>
          <th class="th">제목</th>
          <th class="th">기한</th>
          <th class="th">(아이디)이메일</th>
          <th class="th">버튼</th>
          <th class="th">버튼</th>
        </tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${not empty todoListVO.todoList}">
            <c:forEach items="${todoListVO.todoList}" var="todo">
              <tr>
                <td class="td">${todo.id}</td>
                <td class="td">${todo.status}</td>
                <td class="td">${todo.subject}</td>
                <td class="td">${todo.deadline}</td>
                <td class="td">${todo.memberVO.id} (${todo.memberVO.email})</td>
                <td class="td">
                  <c:if test="${todo.status != 'DONE'}">
                    <a href="<c:url value='/todo/modify/${todo.id}' />">
                      <button class="doneBtn">완료</button>
                    </a>
                  </c:if>
                </td>
                <td class="td">
                  <a href="<c:url value='/todo/delete/${todo.id}' />">
                    <button class="deleteBtn">삭제</button>
                  </a>
                </td>
              </tr>
            </c:forEach>
          </c:when>
          <c:otherwise>
            <tr>
              <td colspan="6">할 일이 없습니다</td>
            </tr>
          </c:otherwise>
        </c:choose>
      </tbody>
    </table>
    <div class="btn-box">
      <a href="/todo/excel/download">
        <button type="button">엑셀 다운로드</button>
      </a>
      <button class="submitBtn" onclick="location.href='/todo/write'">
        새 아이템 추가
      </button>
    </div>
  </body>
</html>
