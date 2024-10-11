<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c"
uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>로그인</title>
    <link rel="stylesheet" type="text/css" href="/css/todo.css" />
  </head>
  <body>
    <h1>로그인</h1>
    <form:form modelAttribute="loginMemberVO" method="post">
      <div class="grid">
        <label for="email">이메일</label>
        <div>
          <form:errors path="email" element="div" cssClass="errors" />
          <c:if test="${not empty message}">
            <div class="errors">${message}</div>
          </c:if>
          <input
            type="email"
            id="email"
            name="email"
            value="${loginMemberVO.email}"
          />
        </div>
        <label for="password">비밀번호</label>
        <div>
          <form:errors path="password" element="div" cssClass="errors" />
          <div class="errors">${message}</div>
          <input
            type="password"
            id="password"
            name="password"
            value="${loginMemberVO.password}"
          />
        </div>
        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="로그인" />
          </div>
        </div>
        <div class="btn-group">
          <div class="right-align">
            <a href="/member/regist">
              <button type="button">회원가입</button>
            </a>
          </div>
        </div>
      </div>
    </form:form>
  </body>
</html>
