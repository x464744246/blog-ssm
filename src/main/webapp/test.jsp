<html>

<head>
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>



    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <%--<script src="../../../file/js/fileinput.js" type="text/javascript"></script>
    <script src="../../../file/js/fileinput.min.js" type="text/javascript"></script>
    <link href="../../../file/css/fileinput.min.css" rel="stylesheet">--%>

    <link href="../../../file/to/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />

    <script src="../../../file/to/js/plugins/canvas-to-blob.min.js" type="text/javascript"></script>
    <!-- sortable.min.js is only needed if you wish to sort / rearrange files in initial preview.
     This must be loaded before fileinput.min.js -->
    <script src="../../../file/to/js/plugins/sortable.min.js" type="text/javascript"></script>
    <!-- purify.min.js is only needed if you wish to purify HTML content in your preview for HTML files.
     This must be loaded before fileinput.min.js -->
    <script src="../../../file/to/js/plugins/purify.min.js" type="text/javascript"></script>
    <!-- the main fileinput plugin file -->
    <script src="../../../file/to/js/fileinput.min.js"></script>
    <!-- bootstrap.js below is needed if you wish to zoom and view file content
     in a larger detailed modal dialog -->

    <script src="../../../file/to/themes/fa/theme.js"></script>
    <!-- optionally if you need translation for your language then include
    locale file as mentioned below -->
   <%-- <script src="../../../file/to/js/locales/.js"></script>
--%>

    <script>


       /* $("#input-id").fileinput({
            showUpload : true,
            previewFileType : 'any',
            uploadUrl: "http://up.qiniu.com",
            uploadAsync: true,
            overwriteInitial: false,
      /!*      uploadExtraData: {
                token: token,
                key: "hahahahahahahaha"
            }*!/

        });

        $('#input-id').on('fileuploaded', function(event, data, previewId, index) {
            alert("123fuck");
        });*/
    </script>

</head>

<body>


<label class="control-label">Select File</label>
<input id="input-fa" name="file" type="file"  class="file-loading">
<script>

        $("#input-fa").fileinput({
            theme: "fa",
            uploadUrl: "http://localhost:8080/article/photot",
          //  uploadExtraData: {id: "key", value: "hhhhhhhhhhhh"}
        });


</script>

</body>

</html>
