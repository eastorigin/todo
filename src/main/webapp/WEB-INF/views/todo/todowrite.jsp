<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>TODO 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/todo.css" />
  </head>
  <body>
    <form method="post" class="form">
      <table class="table">
        <tr>
          <td class="td">제목</td>
          <td class="td">
            <input
              type="text"
              name="subject"
              id="subject"
              placeholder="제목 입력"
            />
          </td>
        </tr>
        <tr>
          <td class="td">기한</td>
          <td class="td">
            <input
              type="text"
              placeholder="기한 날짜 선택"
              name="deadline"
              id="deadline"
              onfocus="(this.type='date')"
              onblur="if(this.value===''){this.type='text'}"
            />
          </td>
        </tr>
      </table>
      <div class="btn-box">
        <button type="submit" class="submitBtn">등록</button>
      </div>
    </form>
  </body>
</html>
