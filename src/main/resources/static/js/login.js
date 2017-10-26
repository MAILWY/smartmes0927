$(function () {
    $("#login").on("click", function () {
        var user = $("#userName").val();
        var pass = $("#password").val();
        $.ajax({
            type: "post",
            url: "http://" + iPaddress + "/user/login",
            async: true,
            data: {"userId": user, "userPwd": pass},
            success: function (data) {
                if (data.retCode == "000") {
                    sessionStorage.setItem('UserId', user);
                    location.href = 'mes_a_index.html';
                }
                else {
                    alert(data.retMsg);
                }
            }
        });
    })
})
