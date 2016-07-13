<%--
  Created by IntelliJ IDEA.
  User: lenov0
  Date: 2016/7/12
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <style>
        .ipt {
            width: 300px;
        }
        label {
            width: 130px;
            display: block;
        }
        ul li {
            list-style:none;
        }
        .ui-progressbar {
            position: relative;
        }
        .progress-label {
            position: absolute;
            left: 50%;
            top: 4px;
            font-weight: bold;
            text-shadow: 1px 1px 0 #fff;
        }
        #progressbar{
            height:30px;
            display:none;
        }
        #dialog{
            display:none;
        }
    </style>
    <script>


        $(document).ready(function() {
        var Qiniu_UploadUrl = "http://up.qiniu.com";
        $("#btn_upload").click(function() {
            //普通上传
            var Qiniu_upload = function(f, token, key) {
                var xhr = new XMLHttpRequest();
                xhr.open('POST', Qiniu_UploadUrl, true);
                var formData, startDate;
                formData = new FormData();
                if (key !== null && key !== undefined) formData.append('key', key);
                formData.append('token', token);
                formData.append('file', f);
                var taking;

                xhr.onreadystatechange = function(response) {
                    if (xhr.readyState == 4 && xhr.status == 200 && xhr.responseText != "") {
                        var blkRet = JSON.parse(xhr.responseText);
                        console && console.log(blkRet);
                    } else if (xhr.status != 200 && xhr.responseText) {

                        alert(xhr.responseText);
                    }
                };
                startDate = new Date().getTime();
                xhr.send(formData);
            };
            var token ;
            $.ajaxSettings.async = false;
            $.getJSON("http://localhost:8080/test/token",function(data){
                token = data.token;
                alert(token);
                if ($("#file")[0].files.length > 0 ) {
                    Qiniu_upload($("#file")[0].files[0], token, $("#key").val());
                } else {
                    console && console.log("form input error");
                }
            });



        })
    })
    </script>
</head>
<body >
<ul>
    <li>
        <label for="token">token:</label>
        <input id="token" name="token" class="ipt" value=""><a target="blank" href="http://jsfiddle.net/gh/get/extjs/4.2/icattlecoder/jsfiddle/tree/master/uptoken">在线生成token</a>
    </li>
    <li>
        <label for="key">key:</label>
        <input id="key" name="key" class="ipt" value="">
    </li>
    <li>
        <label for="bucket">照片:</label>
        <input id="file" name="file" class="ipt" type="file" />
    </li>
    <li>
        <input id="btn_upload" type="button" value="提交">
    </li>
    <div id="progressbar"><div class="progress-label"></div></div>
</ul>
<div id="dialog" title="上传成功"></div>
</body>
</html>
