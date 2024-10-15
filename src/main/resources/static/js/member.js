$().ready(function () {
  var isIdChecked = false;
  var isEmailChecked = false;

  $("#checkId").on("click", function () {
    var id = $("#id").val();
    $.ajax({
      url: "/member/regist/available/id",
      type: "GET",
      data: { id: id },
      success: function (response) {
        if (response.available) {
          alert("사용 가능한 아이디입니다");
          isIdChecked = true;
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
          isEmailChecked = true;
        } else {
          alert("중복된 이메일입니다");
        }
      },
    });
  });

  $("form").on("submit", function () {
    if (!isIdChecked) {
      alert("아이디 중복확인을 해주세요");
      e.preventDefault;
      return;
    }

    if (!isEmailChecked) {
      alert("이메일 중복확인을 해주세요");
      e.preventDefault;
      return;
    }
  });
});
