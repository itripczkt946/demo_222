<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2019/3/16
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/jquery.min.js"></script>
    <script type="text/javascript">

        //修改数量
        function updateNum(){
            var num = $("#num").val();
            var remaining = $("#remaining").text();
            var price = $("#price").text();

            $("#remaining").text(parseInt(remaining) - parseInt(num));
            $("input[name=remaining]").val(parseInt(remaining) - parseInt(num));
            $("#totalPrice").text(parseInt(num)*parseInt(price));
        }

    </script>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/goodsdetail/doUpdate?id=${detail.id}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td colspan="2">购买商品</td>
            </tr>
            <tr>
                <td>商品编号</td>
                <td>${detail.id}</td>
            </tr>
            <tr>
                <td>商品名称</td>
                <td>${detail.name}</td>
            </tr>
            <tr>
                <td>商品分类</td>
                <td>${detail.goodsSort.name}</td>
            </tr>
            <tr>
                <td>商品单价</td>
                <td id="price">${detail.price}</td>
            </tr>
            <tr>
                <td>剩余数量</td>
                <td >
                    <span id="remaining">${detail.remaining}</span>
                    <input type="hidden" value="${detail.remaining}" name="remaining">
                </td>
            </tr>
            <tr>
                <td>购买数量</td>
                <td><input type="text" id="num" value="0" onkeyup="updateNum()"/></td>
            </tr>
            <tr>
                <td>总金额</td>
                <td id="totalPrice"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="购买" />
                    <input type="button" value="返回"  onclick="javascript:location.href='/goodsdetail/findAll'" />
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
