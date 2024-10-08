<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>회원가입</title>
  </head>
  <body>
    <h1>회원가입</h1>
    <form:form
      modelAttribute="registMemberVO"
      method="post"
      action="/member/regist"
    >
      <div class="grid">
        <label for="email">이메일</label>
        <div>
          <form:errors path="email" element="div" cssClass="errors" />
          <input
            type="email"
            id="email"
            name="email"
            value="${registMemberVO.email}"
          />
        </div>
        <button>중복 확인</button>
        <label for="id">아이디</label>
        <div>
          <form:errors path="id" element="div" cssClass="errors" />
          <input type="text" id="id" name="id" value="${registMemberVO.id}" />
        </div>
        <button>중복 확인</button>
        <label for="password">비밀번호</label>
        <div>
          <form:errors path="password" element="div" cssClass="errors" />
          <input
            type="password"
            id="password"
            name="password"
            value="${registMemberVO.password}"
          />
        </div>
        <label for="confirmPassword">비밀번호 확인</label>
        <div>
          <form:errors path="confirmPassword" element="div" cssClass="errors" />
          <input
            type="password"
            id="confirmPassword"
            name="confirmPassword"
            value="${registMemberVO.confirmPassword}"
          />
        </div>
        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="등록" />
          </div>
        </div>
      </div>
    </form:form>
  </body>
</html>
