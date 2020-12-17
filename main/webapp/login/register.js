let oPass=document.getElementById("u_pass0");
let oPass1=document.getElementById("u_pass1");
let name=document.getElementById("u_name");
//提交注册
function SubmitRegister() {
    // let tips = document.getElementById("tips");

    //判断用户名是否为空
    if (!MyForm_Register.u_name.value) {
        window.alert("请输入账户名！");
        MyForm_Register.u_name.focus();
        return false;
    }
    //判断密码是否为空
    if (!MyForm_Register.u_pass0.value) {
        window.alert("请输入登录密码！");
        MyForm_Register.u_pass0.focus();
        return false;
    }
    if(MyForm_Register.u_pass0.value!=MyForm_Register.u_pass1.value)
    {
        window.alert("两次输入的密码不一致");
        MyForm_Register.u_pass1.focus();
        return false;
    }
    //校验成功
    return true;
}

