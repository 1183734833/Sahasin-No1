<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/3
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加回复</title>
</head>
<body>
    <form>
        <table border="1px" cellspacing="0px" width="40%" align="center">
            <tr>
                <td style="background-color: #8EFFFF" align="center">
                    <h2>
                        添加回复<input type="hidden" value="${invid}" id="invid" name="invid">
                    </h2>
                </td>
            </tr>
            <tr>
                <td>
                    回复内容：<textarea rows="4" cols="40" name="content" id="content"></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    回复昵称：<input type="text" name="author" id="author">
                </td>
            </tr>
            <tr>
                <td align="center">
                    <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" id="back">
                </td>
            </tr>
        </table>
    </form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script>
    $(function () {
        $("#back").click(function () {
            window.location.href="InvitationListPage"
        })
        $("form").submit(function () {
            if($("#content").val()==""){
                alert("请填入回复内容");
                return false;
            }
            if($("#author").val()==""){
                $("#author").attr(value,"匿名用户");
                return false;
            }

            $.ajax({
                "url":"AddReply",
                "type":"post",
                "data": $("form").serialize(),
                "dataType" : "json",
                "success":function (data) {
                    if(data){
                        alert("回复添加成功！");
                        window.location.href="InvitationListPage";
                    } else {
                        alert("回复添加失败！");
                    }
                }
            })
            return false;
        })
    })
</script>
</html>
