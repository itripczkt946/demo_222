<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2019/3/16
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/jquery.min.js"></script>
    <script type="text/javascript">

        function findSort(){

            $("#myform").submit();
        }


        function pageNav(pageNo,form){

            form.pageNo.value = pageNo;
            form.submit();

        }


    </script>
</head>
<body>


<c:if test="${empty pageTool}">
    <c:redirect url="${pageContext.request.contextPath}/goodsdetail/findAll?pageNo=1"></c:redirect>
</c:if>


<div>
    <form method="post" action="${pageContext.request.contextPath}/goodsdetail/findAll" id="myform">
    请选择商品分类：
    <select id="sorts" name="sortId" onchange="findSort()">
        <option value="">--请选择--</option>
        <c:forEach items="${goodsSortsList}" var="sorts">
            <option value="${sorts.id}">${sorts.name}</option>
        </c:forEach>
    </select>

    <input type="hidden" name="pageNo" value="1"/>
</form>

    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品分类</th>
            <th>产地</th>
            <th>生产日期</th>
            <th>单价(元)</th>
            <th>剩余数量</th>
            <th>修改</th>
        </tr>
        <c:forEach items="${pageTool.list}" var="detail">
            <tr>
                <td>${detail.id}</td>
                <td>${detail.name}</td>
                <td>${detail.goodsSort.name}</td>
                <td>${detail.address}</td>
                <td>${detail.createDate}</td>
                <td>${detail.price}</td>
                <td>${detail.remaining}</td>
                <td><a href="${pageContext.request.contextPath}/goodsdetail/toDetailPage?id=${detail.id}">购买</a></td>
            </tr>
        </c:forEach>
    </table>
    <div><!--${pageContext.request.contextPath}/goodsdetail/findAll?pageNo=1-->
        <a href="javascript:pageNav(1,document.forms[0])"> 首页</a>
        <!--${pageContext.request.contextPath}/goodsdetail/findAll?pageNo=${pageTool.currentPageNo -1}-->
        <a href="javascript:pageNav(${pageTool.currentPageNo -1},document.forms[0])"> 上一页</a>
        <a href="javascript:pageNav(${pageTool.currentPageNo +1},document.forms[0])"> 下一页</a>
        <a href="javascript:pageNav(${pageTool.pageTotalCount},document.forms[0])"> 末页</a>
        第${pageTool.currentPageNo}页/共${pageTool.pageTotalCount}页
    </div>



</div>



</body>
</html>
