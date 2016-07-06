<%--
  Created by IntelliJ IDEA.
  User: lenov0
  Date: 2016/7/6
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        $(document).ready(function(){
            $("button").click(function(){
                $.get("http://localhost:8080/user/editItemSubmit_RequestJson",function(data,status){
                    $(data).each(function(){
                        alert(this.username);
                    });
                });
            });
        });
    </script>
</head>
<body>

<button>发送一个 HTTP GET 请求并获取返回结果</button>

</body>
</html>
<%--<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        function request_json(){
          //  alert("123");
        $.ajax({
            type:"get",
            url:"http://localhost:8080/user/editItemSubmit_RequestJson",
            dataType:"json",
            success: [function(data , textStatus){
                document.getElementById("test").innerHTML = "123";
                alert(textStatus);
            }]
        });
    }</script>
</head>
<body>
<button id = "123" onclick="request_json()">123</button>
<p2><label id="test" style="color: red"></label></p2>
</body>
</html>--%>
