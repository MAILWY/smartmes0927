$(function () {
    var userName = '';
    var cd = '';

    //alluser
    $.ajax({
        type: "get",
        url: "http://" + iPaddress + "/user/select",
        async: true,
        success: function (data) {
            $.each(data, function (index, val) {
                userName += `<li>
	         			<label for="spring"><input type="radio" name="user" id="` + val.userId + `"/>` + val.userName + `:ID:` + val.userId + `</label>
	   				</li>`;
            });
            $("#left").html(userName);
            rad();
        }
    });
    //allmenu
    $.ajax({
        type: "get",
        url: "http://" + iPaddress + "/menu/select",
        async: true,
        success: function (data) {
            $.each(data, function (index, val) {
                cd += `<li><input type="checkbox" id="` + val.menuid + `"/>` + val.menuName + `</li>`;
            });
            $("#right").html(cd);
            che();
        }
    });

    function rad() {
        $(':radio').on('click', function () {
            $.each($(":checkbox"), function () {
                $(this)[0].checked = false;
            });
            var menuArr = [];
            var UserId = $(this).attr("id");
            sessionStorage.setItem("editUser", UserId);
            $.ajax({
                type: "get",
                url: "http://" + iPaddress + "/usermenu/select",
                async: true,
                data: {"userId": UserId},
                success: function (data) {
                    $.each(data, function (index, val) {
                        menuArr.push(val.menuId);
                    });
                    $.each(menuArr, function (i, v) {
                        $.each($(":checkbox"), function () {
                            if ($(this).attr("id") == v) {
                                $(this)[0].checked = true;
                            }
                        });
                    });
                }
            });
        })
    }

    function che() {
        $(':checkbox').on('click', function (e) {
            var userId = sessionStorage.getItem("editUser");
            var meId = $(this).attr('id');
            if (userId == null) {
                e.preventDefault();
                alert("请选择用户");
            } else {
                var state = $(this)[0].checked;
                if (state) {
                    setState("/usermenu/insert", userId, meId);
                } else {
                    setState("/usermenu/delete", userId, meId);
                }
            }
        })
    }

    function setState(stateUrl, user, menu) {
        setTimeout(function () {
            $.ajax({
                type: "get",
                url: "http://" + iPaddress + stateUrl,
                async: true,
                data: {"userId": user, "menuId": menu, "operId": sessionStorage.getItem("UserId")},
                success: function (data) {
                    console.log(data)
                }
            });
            console.log({"userId": user, "menuId": menu, "operId": sessionStorage.getItem("UserId")})
        }, 300)
    }
})