$().ready(function () {
  $("#checkId").on("click", function () {
    var id = $("#id").val();
    $.ajax({
      url: "/member/regist/available/id",
      type: "GET",
      data: { id: id },
      success: function (response) {
        if (response.available) {
          alert("사용 가능한 아이디입니다");
        } else {
          alert("중복된 아이디입니다");
        }
      },
    });
  });

  $("#checkEmail").on("click", function () {
    var email = $("#email").val();
    $.ajax({
      url: "/member/regist/available/email",
      type: "GET",
      data: { email: email },
      success: function (response) {
        if (response.available) {
          alert("사용 가능한 이메일입니다");
        } else {
          alert("중복된 이메일입니다");
        }
      },
    });
  });
});
