/**
 * Created by lenov0 on 2016/7/13.
 */
jQuery.fn.extend({
    dccUploadFiles: function(uploadConf){
        var _this=this;
        var dccUpFunc = function(_uploadConf){
            var newName=_this.find("input[type=file]").prop("name")+"_upload";
            var newInput = document.createElement("input");
            newInput.setAttribute("name",newName);
            newInput.setAttribute("type","hidden");
            _this.parents("form").append(newInput);
            this.val=[];
            var self = this;
            //加载值
            if(!_uploadConf){
                throw "uploadConf is not found!";
            }
            var fileInput=_this.find("input[type=file]");

            var _defConf={
                width:_uploadConf.width||50,//px
                height:_uploadConf.height||50,//px
                max:_uploadConf.max||20,//最大上传数量
            }
            fileInput.css("cssText","width:"+_defConf.width+"px!important");
            _this.css("cssText","width:"+_defConf.width+"px!important");

            //设置表单为不可视模式
            fileInput.css({
                "height":_defConf.height+"px",
                "opacity":0,
                "position":"absolute",
                "top":"0px",
                "left":"0px",
                "padding":"0px",
                "margin":"0px"
            });

            //设置按钮样式
            _this.css({
                "height":_defConf.height+"px",
                "background":"#fff",
                "border":"dotted #999 1px",
                "font-size":"25px",
                "line-height":_defConf.height*0.9+"px",
                "text-align":"center",
                "color":"#999",
                "position":"relative",
                "display":"inline-block",
                "float":"left",
            });

            _this.prepend("+");

            fileInput.on("change",function(){
                //max
                if(_this.parent().find(".C_dcc_imgbox_show").length>=_defConf.max){
                    alert("最多上传"+_defConf.max+"张图片,您已经达到最大上限了!");
                    $(this).val("");
                    return;
                }
                uploadFile($(this));
                $(this).val("");
            });

            var uploadFile=function(file){

                //创建FormData对象
                var data = new FormData();
                $.each(file[0].files, function(i, file) {
                    data.append('upload_file', file);
                });

                addLoadingbox();
                //发送数据
                $.ajax({
                    url:_uploadConf.uploadUrl,
                    type:'POST',
                    data:data,
                    cache: false,
                    contentType: false,        //不可缺参数
                    processData: false,        //不可缺参数
                    success:function(data){
                        //data = $(data).html();
                        //console.log(data);
                        addPicShow(Base_Url+"/"+data.filepath);

                        //把返回的值填入
                        self.val.push(data.filepath);

                        $(newInput).val(self.val.join());
                    },
                    error:function(e){
                        alert('上传出错');
                        throw e;
                        setTimeout(
                            function(){
                                $("#J_dcc_loadingId").remove();
                            },200);

                    }
                });
            }
            var addLoadingbox=function(){
                var loadingbox = document.createElement("div");
                $(loadingbox).prop("id","J_dcc_loadingId");
                $(loadingbox).css({
                    "width":_defConf.width+"px",
                    "height":_defConf.height+"px",
                    "background":"#fff",
                    "border":"dotted #999 1px",
                    "font-size":"12px",
                    "line-height":_defConf.height*0.9+"px",
                    "text-align":"center",
                    "color":"#999",
                    "margin-right":"10px",
                    "display":"inline-block",
                    "float":"left",
                    "text-algin":"center",
                });
                $(loadingbox).text("上传中...");
                _this.before(loadingbox);
            }
            var addPicShow=function(picurl){
                $("#J_dcc_loadingId").remove();
                var imgbox = document.createElement("div");
                $(imgbox).addClass("C_dcc_imgbox_show");
                $(imgbox).css({
                    "width":_defConf.width+"px",
                    "height":_defConf.height+"px",
                    "background":"#fff",
                    "border":"dotted #999 1px",
                    "font-size":"25px",
                    "line-height":_defConf.height*0.9+"px",
                    "text-align":"center",
                    "color":"#999",
                    "background-image":"url("+picurl+")",
                    "background-size":"cover",
                    "background-position":"center",
                    "margin-right":"10px",
                    "display":"inline-block",
                    "float":"left",
                    "position":"relative",
                });
                var delbox = document.createElement("a");
                $(delbox).css({
                    "width":_defConf.width+"px",
                    "height":_defConf.height+"px",
                    "background":"#fff",
                    "border":"0px",
                    "font-size":"13px",
                    "line-height":_defConf.height*0.9+"px",
                    "text-align":"center",
                    "color":"#999",
                    "background":"rgba(0,0,0,.8)",
                    "margin-right":"10px",
                    "display":"block",
                    "float":"left",
                    "position":"absloute",
                    "color":"#dddddd",
                    "top":"0px",
                    "left":"0px",
                    "opacity":"0",
                    "text-decoration":"initial"
                }).text(" X 删除").on("mouseover",function(){
                    $(this).css("opacity","1");
                }).on("mouseout",function(){
                    $(this).css("opacity","0");
                }).on("click",function(){
                    if(confirm("确定要删除吗？")){
                        $(imgbox).remove();
                        //把返回的值填入
                        for(var n=0;n<self.val.length;n++){
                            if(picurl==self.val[n]){
                                self.val.splice(n,1);
                                break;
                            }
                        }
                        $(newInput).val(self.val.join());
                        if(uploadConf.delUrl){ //如果有删除url 则进行后台删除
                            $.post(uploadConf.delUrl,{"picpath":picurl},function(data){
                                //删除成功

                            },'json');
                        }
                    }
                });
                $(imgbox).append(delbox);
                _this.before(imgbox);
            }
            //初始化默认数据
            var defaultVal = fileInput.attr("default-val");
            if(defaultVal){
                this.val = defaultVal.split(",");
                for(index in this.val){
                    addPicShow(Base_Url+"/"+this.val[index]);
                }
                $(newInput).val(this.val.join());
            }
        }
        var dccUpFunc = new dccUpFunc(uploadConf);
    }
});