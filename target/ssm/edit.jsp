<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<head lang="en">
    <meta charset="UTF-8">
    <title>ChenDiDi's Rocks</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="alternate icon" type="../../../file/image/png" href="assets/i/favicon.png">
    <link rel="stylesheet" href="../../../file/assets/css/amazeui.min.css"/>
    <link rel="stylesheet"
          href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script
            src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../../../file/css/default.css">

    <link href="../../../file/to/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>

    <script src="../../../file/to/js/plugins/canvas-to-blob.min.js" type="text/javascript"></script>

    <script src="../../../file/to/js/plugins/sortable.min.js" type="text/javascript"></script>

    <script src="../../../file/to/js/plugins/purify.min.js" type="text/javascript"></script>

    <script src="../../../file/to/js/fileinput.min.js"></script>

    <script src="../../../file/to/themes/fa/theme.js"></script>


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
        function add() {
            var title = $('#title').val();
            var article = $('#article').val();
            title = encodeURI(title);
            article = encodeURI(article);

            $.ajax({ //一个Ajax过程
                type: "post", //以post方式与后台沟通
                url: "http://localhost:8080/article/add", //与此页面沟通
                dataType: 'json',//返回的值以 JSON方式 解释
                data: {"title": title, "article": article}, //发给的数据
                success: function (json) {//如果调用成功
                    if (json.flag) {
                        alert("添加成功");
                        self.location = 'http://localhost:8080/article/article';
                    } else {
                        alert("添加失败");
                    }
                }
            });
        }
    </script>


</head>

<body>

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
            <li class="active"><a href="http://localhost:8080/article/article">首页</a></li>
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
                    <li><a href="http://localhost:8080/user/password">更改密码</a></li>
                    <li class="divider"></li>
                    <li><a href="http://localhost:8080/user/login_out">退出登录</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
</br>
</br>
</br>
<div class="row container-fluid">
    <div class="col-md-10 col-md-offset-1">

        <form id="edit" name="edit" action="" role="form">
            <div class="form-group">
                <label>标题</label> </br> <input id="title" type="text"
                                               name="title" class="form-control" placeholder="文本输入">
            </div>

            <div class="form-group">
                </br> <label>内容</label> </br>
					<textarea id="article" name="article" class="form-control"
                              rows="18"></textarea>
                <input id="input-fa" name="files" type="file" multiple class="file-loading">
                <script>

                    $("#input-fa").fileinput({
                        theme: "fa",
                        uploadUrl: "http://localhost:8080/article/photos",
                        //  uploadExtraData: {id: "key", value: "hhhhhhhhhhhh"}
                    });


                </script>
            </div>

            <!-- 	<div class="form-group">
                </br> <input name="images" id="file-0a" class="file" type="file" multiple
                    data-min-file-count="1"> </br>

            </div> -->

            <div class="am-cf ">
                </br> <input id="send" type="button" name="" value="发   表 " onclick="add()"
                             class="am-btn am-btn-primary am-btn-sm am-fl am-u-sm-centered">
            </div>
        </form>

    </div>
</div>
<!-- onClick="this.form.action='./Message_AddCheckAction.action'" -->

</body>

</html>