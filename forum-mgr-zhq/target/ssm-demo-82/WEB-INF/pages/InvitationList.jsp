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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>帖子列表</title>
</head>
<body>
        <table border="1px" cellspacing="0px" width="40%" align="center">
            <tr>
                <td colspan="5" align="center">
                    <h1>帖子列表</h1>
                </td>
            </tr>
            <tr>
                <td colspan="5" align="center">
                    <form action="InvitationListPage" method="post">
                        帖子标题：<input type="text" name="searchInfo" id="searchInfo">&nbsp;<input type="submit" value="搜索">
                        <input type="hidden" name="pageNo" id="pageNo" value=""/>
                    </form>
                </td>
            </tr>
            <tr align="center" style="background-color: #84C1FF">
                <td>标题</td>
                <td>内容摘要</td>
                <td>作者</td>
                <td>发布时间</td>
                <td>操作</td>
            </tr>
            <tbody>
            <c:if test="${invitations.size()==0}" var="flag">
                <tr>
                    <td colspan="5" align="center">抱歉！暂无帖子</td>
                </tr>
            </c:if>
            <c:if test="${!flag}">
                <c:forEach items="${invitations}" var="invitation" varStatus="status">
                    <tr align="center" <c:if test="${status.count%2!=0}"> style="background-color: #8EFFFF"
                    </c:if>>
                        <td>${invitation.title}</td>
                        <td>${invitation.summary}</td>
                        <td>${invitation.author}</td>
                        <td>${invitation.createdate}</td>
                        <td><a href="toReplyList?id=${invitation.id}">查看回复</a>&nbsp;||&nbsp;<a href="delete?id=${invitation.id}" class="del">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
            <tfoot>
                <c:if test="${!flag}">
                    <tr>
                        <td align="center">
                            第${page.currentPageNo}/${page.totalPage}页
                        </td>
                        <td colspan="4" align="center">
                            <a href="1">首页</a>&nbsp;|&nbsp;
                            <a href="${page.currentPageNo-1}">上一页</a>&nbsp;|&nbsp;
                            <a href="${page.currentPageNo+1}">下一页</a>&nbsp;|&nbsp;
                            <a href="${page.totalPage}">末页</a>
                        </td>
                    </tr>
                </c:if>
            </tfoot>
        </table>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script>
    $(function () {
        // 提交翻页
        $("tfoot a").click(function () {
            $("#pageNo").attr("value", $(this).attr("href"));
            $("form").submit();
            return false;
        })
        $(".del").click(function () {

            if(!window.confirm("“确定删除该条发帖及相关回复？")){
                return false;
            }
            var obj = $(this);
            var str = obj.attr("href");
            $.getJSON(str,function (data) {
                if(data){
                    obj.parents("tr").remove();
                    $("tfoot").append("<tr align='center'><td colspan='5' style='color: red;'>删除成功</td></tr>")
                } else {
                    $("tfoot").append("<tr align='center'><td colspan='5' style='color: red;'>删除失败</td></tr>")
                }
            });
            return false;
        });
    })
</script>
</html>

