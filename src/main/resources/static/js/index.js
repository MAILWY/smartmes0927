$(function () {
    $(window).on('resize', function () {
        var $content = $('.admin-nav-card .layui-tab-content');
        $content.height($(this).height() - 105);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }).resize();

    var TabList = '';

    var UserId = sessionStorage.getItem("UserId");
    var UserName = sessionStorage.getItem("UserName");
    $("#header-user").html("用户：" + UserName + "	     " + "ID：" + UserId);
    $.ajax({
        type: "post",
        url: "http://" + iPaddress + "/usermenu/select",
        async: true,
        data: {"userId": UserId},
        success: function (data) {
            $.each(data, function (index, val) {
                TabList += "<li id='" + val.menuResource + "' class='layui-nav-item'><a><cite>" + val.menuName + "</cite></a></li>";
            });
            $("#TabList").html(TabList);
            //用jQuery去监听按钮是否被点击
            $(".layui-nav-item").click(function () {
                //被点击按钮的id
                //alert($(this).attr('id'));
                $(".menu_iframe").attr("src", $(this).attr('id') + ".html");
            });
        }
    });


//菜单滑动
    $('.admin-side-toggle').on('click', function () {
        var sideWidth = $('#admin-side').width();
        if (sideWidth === 200) {
            $('#admin-body').animate({
                left: '0'
            }); //admin-footer
            $('#admin-footer').animate({
                left: '0'
            });
            $('#admin-side').animate({
                width: '0'
            });
        } else {
            $('#admin-body').animate({
                left: '200px'
            });
            $('#admin-footer').animate({
                left: '200px'
            });
            $('#admin-side').animate({
                width: '200px'
            });
        }
    });
    //全屏
    $('.admin-side-full').on('click', function () {
        var docElm = document.documentElement;
        //W3C  
        if (docElm.requestFullscreen) {
            docElm.requestFullscreen();
        }
        //FireFox  
        else if (docElm.mozRequestFullScreen) {
            docElm.mozRequestFullScreen();
        }
        //Chrome等  
        else if (docElm.webkitRequestFullScreen) {
            docElm.webkitRequestFullScreen();
        }
        //IE11
        else if (elem.msRequestFullscreen) {
            elem.msRequestFullscreen();
        }
    });
})
