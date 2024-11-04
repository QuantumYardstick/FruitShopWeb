$(function (){
    $("#choicePhoto").click(function () {
        $("#fileToUpload").click(); //出发文件选择器的click事件
    });
    //当文件选择器的文件选择发生修改时
    $("#fileToUpload").change(function(){
        var files = $("#fileToUpload")[0].files;
        if(files.length<=0){
            return alert('请选择文件后再上传');
        }

        var formData = new FormData();
        formData.append("file",files[0]);
        alert("请求")
        alert(files[0].name)  //显示以下上传文件的名称
        $.ajax({  //使用ajax异步调用服务器中的url
            url:"upload.do",
            data:formData,
            cache:false,
            type:"post",
            datatype:"json",
            contentType:false, //不设置内容类型
            processData:false, //不处理数据
            success:function (data){
                if(data.code==0) {  //当data.code==0的时候代表上传文件成功
                    alert(data.msg); //显示从服务器中发回来的消息提示
                    $("#imgs").val("/" + data.result); //把上传后存储在服务器中的文件名称回填给文本框
                    $("#fruitphoto").attr("src","/upload/"+data.result);
                }else{  //失败
                    alert(data.msg);
                }
            }
        })
    })
})