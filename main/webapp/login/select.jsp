<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/12/2
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多级联动</title>
</head>
<body>
<%--##########前台页面##########--%>
<select name="province" id="provinceId">
    <option value="-1">请选择省份</option>
    <option>广东</option>
    <option>湖南</option>
</select>
<select name="city" id="cityId">
    <option>请选择城市</option>
</select>

<%--AJAX--%>
<script type="text/javascript">

    document.getElementById("provinceId").onchange=function(){
        // 定位到下拉框，获取下拉框的值
        // 获取选中的下拉框的索引值
        let index=this.selectedIndex;
        // 得到下拉框的值
        let province=this.options[index].innerText;
        // 下拉框的值要是"请选择",那么我们是不会访问服务器的
        if("请选择省份"!=province){
            // 由于每次都会自动添加，所以在每次调用时清除
            let citySelect=document.getElementById("cityId");
            // 每次都将option编程长度只有1的
            citySelect.options.length=1;
            // ajax代码
            // 创建AJAX对象
            // window对象中XMLHttpRequest存在就是IE6以上
            let ajax;
            if(window.XMLHttpRequest){
                ajax=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                ajax=new ActiveXObject("Microsoft.XMLHTTP");
            }
            // 准备发送请求
            let method="post";
            let url="ProvinceServlet";
            // open方法创建http请求，三个参数分别代表“提交方式”、“提交地址”、“同步或异步（true为异步）”
            ajax.open(method,url,true);
            // 由于是post方式，因此要设置头
            ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
            // send发送请求给服务器，如果是post方式，要把提交的参数写上去
            ajax.send("province="+province);

            // ajax回调函数
            ajax.onreadystatechange=function (){
                if(ajax.readyState==4){
                    if(ajax.status==200){
                        // 得到服务器带过来的xml
                        let XMLDocument=ajax.responseXML;
                        // 解析XML文档，使用DOM写到下拉框中
                        let cities=XMLDocument.getElementsByTagName("city");
                        // 得到每一个cities节点的值，动态生成下拉框，添加到下拉框中
                        for(let i=0;i<cities.length;i++){
                            let value=cities[i].firstChild.nodeValue;
                            // 动态生成下拉框
                            let optionElement=document.createElement("option");
                            optionElement.innerHTML=value;
                            // 添加到下拉框中
                            citySelect.appendChild(optionElement);
                        }
                    }
                }
            }
        }
    }

</script>
</body>
</html>
