//提交登录
function SubmitLogin() {
    // let tips = document.getElementById("tips");

    //判断用户名是否为空
    if (!myForm.login_name.value) {
        window.alert("请输入登录账户！");
        myForm.name.focus();
        return false;
    }
    //判断密码是否为空
    if (!myForm.login_password.value) {
        window.alert("请输入登录密码！");
        myForm.login_password.focus();
        return false;
    }
    //校验成功
    return true;
}
function getBasePath(){
    return 'http://localhost:63342/JavaWeb/web/login';
}
//
// $(function(){
//     //发送验证码
//     $(".sendVerifyCode").on("click", function(){
//         // window.alert("朋友们好啊");
//         let number = $("input[name=phone]").val();
//         // window.alert(number)
//         // let path=getBasePath();
//         // window.alert(path);
//         $.ajax({
//             url: getBasePath()+"/register.html",
//             async : true,
//             type: "post",
//             dataType: "json",
//             data: {"number":number},
//             success: function (data) {
//                 if(data == 'fail'){
//                     alert("发送验证码失败");
//                     return ;
//                 }else
//                     window.alert("好")
//             }
//         });
//     })
//     //提交
//     $(".sub-btn").on("click", function(){
//         let data = {};
//         // data.userId = $.trim($("input[name=userId]").val());
//         // data.password = $.trim($("input[name=password]").val());
//         data.number = $.trim($("input[name=phone]").val());
//         data.verifyCode = $.trim($("input[name=code]").val());
//         window.alert(data.number);
//         $.ajax({
//             url: getBasePath()+"/register.html",
//             async : true,
//             type: "post",
//             dataType: "json",
//             data: data,
//             success: function (data) {
//                 if(data == 'fail'){
//                     alert("注册失败");
//                     return ;
//                 }
//                 alert("注册成功");
//             }
//         });
//     })
// });




