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
        $(document)
                .ready(
                        function () {

                            $('#search_article')
                                    .click(
                                            function () {

                                                var keyword = $('#keyword').val();
                                                location.href = "./Searching_TitleAction.action?page=1&keyword="
                                                        + encodeURI(encodeURI(keyword));
                                                // $('#messages').bootstrapTable('refresh', { url: './SearchingAction.action?keyword=' + keyword  });
                                            });
                        });
    </script>

    <script>

        function getpage(obj) {
           // alert($(obj).attr("id"));
            var page = $(obj).attr("id");
          //  alert(page);
            if(page==null)
                    page = 1;
            $.ajax({ //一个Ajax过程
                type: "post", //以post方式与后台沟通
                url: "http://localhost:8080/article/page", //与此页面沟通
                dataType: 'json',//返回的值以 JSON方式 解释
                data: 'page=' + page , //发给的数据
                success: function (json) {//如果调用成功
                    if (json.flag) {
                        var tTr;
                        var tTr2;
                        var cp = json.page.current;
                        $("#articlebody").html("");
                        $("#page").html("");
                        $.each(json.article, function (i, n) {

                            tTr =tTr+ "<tr><td class='center'><span class='center'>"
                                    + "<a href='../../reply/reply?articleid=" + n.articleid + "'>" + n.title + "</a></span></td><td class='center'><span class='center'>" +
                                    n.username + "</span></td><td class='center'><span class='center'>" + n.createdate + "</span></td></tr>";


                        });
                        tTr2 = " <li ><a id='-1' href='#' onclick='getpage(this)'>&laquo;</a></li>";
                        $.each(json.page.perPage, function (j, p) {

                            if(p==cp)
                            tTr2 =tTr2 +" <li  class='active'><a id="+ p+" href='#' onclick='getpage(this)'>"+p+"</a></li>";
                            else
                                tTr2 =tTr2 +" <li ><a id="+ p+" href='#' onclick='getpage(this)'>"+p+"</a></li>";

                        });
                        tTr2 =tTr2 +" <li ><a id='0' href='#' onclick='getpage(this)'>&raquo;</a></li>";
                        $("#articlebody").append(tTr);
                        $("#page").append(tTr2);
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
            <li><a href="http://localhost:8080/article/edit">添加文章</a></li>
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


<!--搜索栏-->
<div class="container-fluid pull-right">


    <div class="input-append ">
        <input id="keyword" class="span2 " type="text"
               placeholder="输入 标题,作者id,日期" style="width: 339px; height: 26px">

        <div class="btn-group ">
            <button class="btn dropdown-toggle" data-toggle="dropdown">
                Search <span class="caret"></span>
            </button>
            <ul class="dropdown-menu pull-right">
                <li role="presentation"><a id="search_article" role="menuitem"
                                           tabindex="-1" href="#">标题</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1"
                                           href="#">作者id</a></li>
                <li role="presentation"><a role="menuitem" tabindex="-1"
                                           href="#">日期</a></li>
            </ul>
        </div>

    </div>

</div>
<!--表格-->
<div class="container-fluid">
    <table id="messages" class="table table-hover"
           style="table-layout: fixed">
        <thead>
        <tr>
            <th>标题</th>
            <th>作者id</th>
            <th>日期</th>
        </tr>
        </thead>
        <tbody id="articlebody">

        </tbody>
    </table>
    <nav style="text-align: center">
        <ul id="page" class="pagination ">

        </ul>
    </nav>
</div>
</body>

</html>