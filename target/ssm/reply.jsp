<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>ChenDiDi's Rocks</title>
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <link rel="stylesheet"
          href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script
            src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <style type="text/css">
        .table th, .table td {
            text-align: center;
            width: 33%;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
    </style>

    <script type="text/javascript">
        function adel(id) {
            alert(id);
            $.ajax({ //一个Ajax过程
                type: "post", //以post方式与后台沟通
                url: "http://localhost:8080/article/delete", //与此页面沟通
                dataType: 'json',//返回的值以 JSON方式 解释
                data: 'articleid=' + id, //发给的数据
                success: function (json) {//如果调用成功
                    if (json.flag) {
                        alert("删除文章成功");
                        self.location='http://localhost:8080/article/article';

                    }else{
                        alert("删除文章失败");
                    }
                }
            });
        }
        function rdel(id) {
            alert(id);
            $.ajax({ //一个Ajax过程
                type: "post", //以post方式与后台沟通
                url: "http://localhost:8080/reply/delete", //与此页面沟通
                dataType: 'json',//返回的值以 JSON方式 解释
                data: 'replyid=' + id, //发给的数据
                success: function (json) {//如果调用成功
                    if (json.flag) {
                        alert("删除回复成功");
                        getpage(null);
                    }else{
                        alert("删除回复失败");
                    }
                }
            });
        }
        function add() {
            var reply = $("#reply").val();
            $.ajax({ //一个Ajax过程
                type: "post", //以post方式与后台沟通
                url: "http://localhost:8080/reply/add", //与此页面沟通
                dataType: 'json',//返回的值以 JSON方式 解释
                data: 'reply=' + reply, //发给的数据
                success: function (json) {//如果调用成功
                    if (json.flag) {
                        alert("添加成功");
                        $("#reply").val('');
                        getpage(null);
                    }else{
                        alert("添加失败");
                    }
                }
            });
        }
        function getpage(obj) {
            // alert($(obj).attr("id"));
            var page = $(obj).attr("id");
           // alert(page);
            if (page == null)
                page = 1;
            $.ajax({ //一个Ajax过程
                type: "post", //以post方式与后台沟通
                url: "http://localhost:8080/reply/page", //与此页面沟通
                dataType: 'json',//返回的值以 JSON方式 解释
                data: 'page=' + page, //发给的数据
                success: function (json) {//如果调用成功
                    if (json.flag) {
                        var userid = ${sessionScope.u.userid};
                        var userid2 = ${sessionScope.a.userid};
                        var tTr = "</br>" ;
                        var tTr2;
                        var cp = json.page.current;
                        $("#replybody").empty();
                        $("#page").html("");
                        $.each(json.reply, function (i, n) {


                            tTr = tTr + "</br>" +
                                    "<div class='row container-fluid'>" +
                                    "<div class='col-md-2 col-md-offset-1'>" +
                                    "<img src='' class=' img-rounded img-responsive' alt='Cinque Terre'width='228' height='228'>" +
                            "<p class='list-group-item-text'>" + n.username+
                                    "</p></div><div class='col-md-8'> " +
                            "<a href='#' class='list-group-item'>" +
                            " <h4 class='list-group-item-heading'>回复：" + ${sessionScope.a.userid}+
                                    "</h4> <pre class='list-group-item-text'>" + n.reply+
                                    "</pre></a>" +
                            " <button class='btn btn-small btn-link  pull-right' id='delete' type='button' onclick='rdel(\"" + n.replyid+ "\")'>删除回复</button> </div> </div> ";

                        });
                        tTr2 = " <li ><a id='-1' href='#' onclick='getpage(this)'>&laquo;</a></li>";
                        $.each(json.page.perPage, function (j, p) {

                            if(p==cp)
                                tTr2 =tTr2 +" <li  class='active'><a id="+ p+" href='#' onclick='getpage(this)'>"+p+"</a></li>";
                            else
                                tTr2 =tTr2 +" <li ><a id="+ p+" href='#' onclick='getpage(this)'>"+p+"</a></li>";

                        });
                        tTr2 = tTr2 + " <li ><a id='0' href='#' onclick='getpage(this)'>&raquo;</a></li>";
                        $("#replybody").append(tTr);
                        $("#page").append(tTr2);
                        if (userid == userid2)
                            ;
                        else
                            $('[id=delete]').attr("disabled", true);
                    } else {
                        alert("ERROR!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                }
            });



        }


    </script>
</head>

<body onload="getpage(this)">

<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#example-navbar-collapse">
            <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
                class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">ChenDiDi's Rocks</a>
    </div>
    <div class="collapse navbar-collapse" id="example-navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="./Message_PageAction.action?page=1">首页</a></li>
            <li><a href="./Message_AddAction.action">添加文章</a></li>
            <li><a href="./MAndRAction.action?page=1">我的回复</a></li>
            <li class="dropdown"><a href="#" class="dropdown-toggle"
                                    data-toggle="dropdown"> 更多 <b class="caret"></b>
            </a>
                <ul class="dropdown-menu pull-right">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
        </ul>
        <!--用户下拉列表-->
        <ul class="nav pull-right">

            <li class="dropdown"><a data-toggle="dropdown"
                                    class="dropdown-toggle " href="#">${sessionScope.u.username}<strong
                    class="caret"></strong></a>
                <ul class="dropdown-menu pull-right">
                    <li><a href="./PasswordChange.action">更改密码</a></li>
                    <li class="divider"></li>
                    <li><a href="./Login_OutAction.action">退出登录</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>


<!--表格-->
<div class="container-fluid">

    </br>
    <div class="list-group container-fluid">
        <a href="#" class="list-group-item active  container-fluid">
            <h4 class="list-group-item-heading  container-fluid">标题：${sessionScope.a.title}</h4>
        </a> </br>
        <div class="row container-fluid">

            <div class="col-md-2 col-md-offset-1">
                <img src="./image/${sessionScope.a.userid}.jpg"
                     class=" img-rounded img-responsive" alt="Cinque Terre" width="228"
                     height="228">
                <p class="list-group-item-text">${sessionScope.a.username}</p>
            </div>

            <div class="col-md-8">

                <a href="#" class="list-group-item">
                    <h4 class="list-group-item-heading">${sessionScope.a.username}</h4> <pre
                        class="list-group-item-text">${sessionScope.a.article}</pre>

                </a>
                <button class="btn btn-small btn-link  pull-right" id="delete"
                        type="button"
                        onclick="adel('${sessionScope.a.articleid}')">删除主题
                </button>

            </div>

        </div>

    </div>
    </br>
    <div class="list-group  container-fluid">
        <a href="#" class="list-group-item active">
            <h4 class="list-group-item-heading">回复</h4>
        </a>
        <div id="replybody">

        </div>
    </div>

    </br>


    <nav style="text-align: center">
        <ul id="page" class="pagination ">

        </ul>
    </nav>
    <form action="" method="post" role="form">
        <div class="form-group  container-fluid">
            <label>回复区</label>
            <textarea id = "reply" name="rm" class="form-control" rows="3"></textarea>
            <button type="button"
                    class="btn btn-default  pull-right  container-fluid"
                    onClick="add()">回复
            </button>
        </div>

    </form>
</div>
</body>

</html>