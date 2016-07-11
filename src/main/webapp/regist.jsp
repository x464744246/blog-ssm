<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>Let's Rock</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="alternate icon" type="image/png" href="../../../file/assets/i/favicon.png">
    <link rel="stylesheet" href="../../../file/assets/css/amazeui.min.css"/>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <style>
        .header {
            text-align: center;
        }

        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }

        .header p {
            font-size: 14px;
        }
    </style>
    <script type="text/javascript">
        // Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9
        function OnInput1(event) {
            //alert ("The new content: " + event.target.value);
            var value = event.target.value;
            checkuserid(value);
        }
        function OnInput2(event) {
            //alert ("The new content: " + event.target.value);
            var value = event.target.value;
            checkusername(value);
        }
        function OnInput3(event) {
            //alert ("The new content: " + event.target.value);
            var value = event.target.value;
            checkpassword(value);
        }
        function OnInput4(event) {
            //alert ("The new content: " + event.target.value);
            var value = event.target.value;
            checkpassword2(value);
        }
        //验证用户名方法(只能是数字字母和中文，不能包括特殊字符)
        function checkuserid(value) {
            var regex = /^[A-Za-z0-9]{6,15}$/;///^[A-Za-z0-9]+$/
            $.ajax({ //一个Ajax过程
                type: "post", //以post方式与后台沟通
                url: "http://localhost:8080/register/check_id", //与此页面沟通
                dataType: 'json',//返回的值以 JSON方式 解释
                data: 'userid=' + value, //发给的数据
                success: function (json) {//如果调用成功
                    if (json.flag) {
                        document.getElementById("error").innerHTML = "账号已存在";
                    } else {
                        document.getElementById("error").innerHTML = "";
                    }
                }
            });
            if (regex.test(value) == true) {
                //格式正确
                document.getElementById("error1").innerHTML = "";
            } else {
                //格式错误
                document.getElementById("error1").innerHTML = "账号格式错误，账号由6-15位数字、字母组成，不能包含中文以及特殊字符";
            }
        }

        function checkusername(value) {
            var regex = /^[0-9a-zA-Z\u4e00-\u9fa5]{6,15}$/;
            if (regex.test(value) == true) {
                //格式正确
                document.getElementById("error2").innerHTML = "";
            } else {
                //格式错误
                document.getElementById("error2").innerHTML = "昵称格式错误，昵称由6-15位数字、字母、中文组成，不能包含特殊字符";
            }
        }
        function checkpassword(value) {
            var regex = /^[A-Za-z0-9]{8,20}$/;
            if (regex.test(value) == true) {
                //格式正确
                document.getElementById("error3").innerHTML = "";
            } else {
                //格式错误
                document.getElementById("error3").innerHTML = "密码不为空,且为8-20位数字、字母组成，不能包含中文以及特殊字符";
            }
        }
        function checkpassword2(value) {

            if (document.regist.password.value == document.regist.password2.value) {
                //格式正确
                document.getElementById("error4").innerHTML = "";
            } else {
                //格式错误
                document.getElementById("error4").innerHTML = "密码不一致";
            }
        }

    </script>
    <script>
        function register()
        //交由程序1处理
        {
            //alert($("#error").text());
            var error = $("#error").text();
            var error1 = $("#error1").text();
            var error2 = $("#error2").text();
            var error3 = $("#error3").text();
            var error4 = $("#error4").text();
            if (error == null && error1 == null && error2 == null && error3 == null
                    && error4 == null) {
                alert("校验成功，之后进行提交");
                document.regist.action = "http://localhost:8080/register/check_register";
                document.regist.submit();
            } else {
                alert("填写格式错误");
                return false;
            }

        }

    </script>
</head>

<body>
<div class="header">
    <div class="am-g">
        <h1>Register</h1>
    </div>
    <hr/>
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">

        <form name="regist" action="" method="post" class="am-form" onsubmit="register()"
              >
            </br>
            <input name="image" type="file" id="inputfile" size="30"
                         accept="image/*">
            </br>
            <label>账号:</label>
            <input
                type="text" name="userid" id="userid" value=""
                oninput="OnInput1 (event)" placeholder="数字、字母"><label
                id="error" style="color: red"></label> <br> <label
                id="error1" style="color: red"></label> <br> <label
                for="password">昵称:</label> <input type="text" name="username"
                                                  id="username" value="" oninput="OnInput2 (event)"
                                                  placeholder="数字、字母、汉字">
            <p2>
                <label id="error2" style="color: red"></label></p2>
            <br> <label for="password">密码:</label> <input type="password"
                                                          name="password" id="password" value="" oninput="OnInput3 (event)"
                                                          placeholder="输入密码">
            <p2>
                <label id="error3" style="color: red"></label></p2>
            <br> <label for="password">重复密码:</label> <input type="password"
                                                            name="password2" id="password2" value=""
                                                            oninput="OnInput4 (event)"
                                                            placeholder="重复密码">
            <p2>
                <label id="error4" style="color: red"></label></p2>
            <br/>
            <div class="am-cf ">
                <input type="submit" name="" value="注 册"
                       class="am-btn am-btn-primary am-btn-sm am-fl am-u-sm-centered"  >
            </div>
        </form>
        <hr>
        <p>© 2016 ChenDiDi.</p>
    </div>
</div>
</body>

</html>
