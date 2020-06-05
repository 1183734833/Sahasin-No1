<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/29
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>帖子回复</title>
</head>
<body>
    <form>
        <table border="1px" cellspacing="0px" width="40%" align="center">
            <tr>
                <td colspan="3" align="center">
                    <h1>回复信息列表</h1>
                </td>
            </tr>
                <tr>
                    <td colspan="3" align="right">
                         <a href="toAddReply?invid=${invid}" style="color: red;">添加回复</a>&nbsp;&nbsp;&nbsp;<a href="InvitationListPage" style="color: red;">返回帖子列表</a>
                     </td>
                </tr>
            <tr align="center" style="background-color: #84C1FF">
                <td>回复内容</td>
                <td>回复昵称</td>
                <td>发布时间</td>
            </tr>
            <c:if test="${replies.size()==0}" var="flag">
                <tr>
                    <td colspan="3" align="center">抱歉！暂无回复</td>
                </tr>
            </c:if>
            <c:if test="${!flag}">
                <c:forEach items="${replies}" var="reply" varStatus="status">
                    <tr align="center" <c:if test="${status.count%2==0}"> style="background-color: #8EFFFF"
                    </c:if>>
                        <td>${reply.content}</td>
                        <td>${reply.author}</td>
                        <td>${reply.createdate}
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
    </form>
</body>
</html>

