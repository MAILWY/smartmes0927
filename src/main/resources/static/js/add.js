$(function () {
    function getData() {
        var UserList = '';
        $.ajax({
            type: "get",
            url: "http://" + iPaddress + "/user/select",
            async: true,
            success: function (data) {
                $.each(data, function (index, val) {
                    UserList += `<tr>
						<td style="text-align:center;">` + val.userId + `</td>
						<td style="text-align:center;">` + val.userName + `</td>
						<td><button class="layui-btn layui-btn-danger del">删除</button></td>
					</tr>`
                });
                $("#UserList").html(UserList);
                add(data);
                del();
            }
        });
    }

    getData();

    function add(data) {
        $("#add").on("click", function () {
            var user = $("#userId").val();
            var pass = $("#userPwd").val();
            var name = $("#name").val();
            $.each(data, function (index, val) {
                if (val.userId == user) {
                    $("#userId").css({'border': '2px solid #f00', 'color': '#f00'}).val('已存在');
                    setTimeout(function () {
                        $("#userId").css({'border': '1px solid #e6e6e6', 'color': '#000'}).val('');
                    }, 1000);
                    return;
                }
            });
            if (user != '' && name != '') {
                $.ajax({
                    type: "get",
                    url: "http://" + iPaddress + "/user/insert",
                    async: true,
                    data: {"userId": user, "userPwd": pass, "userName": name},
                    success: function (data) {
                        if (data.retCode == "000") {
                            getData();
                        }
                    }
                });
            }
        });
    }

    function del() {
        $(".del").on('click', function () {
            var id = $(this).parent().parent().find('td').first().text();
            console.log(id)
            $.ajax({
                type: "get",
                url: "http://" + iPaddress + "/user/delete",
                async: true,
                data: {"userId": id},
                success: function (data) {
                    if (data.retCode == "000") {
                        getData();
                    }
                }
            });
        });
    }
})
