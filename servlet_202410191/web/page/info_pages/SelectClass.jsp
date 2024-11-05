<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课系统</title>

    <%@include file="../common/head.jsp" %>

    <script type="text/javascript">

        $(function () {
            $("a.delete").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().children("td").eq(0).text() + "】信息吗？");
            })

            $(".submit_btn").click(function () {
                var input_sno = document.form_id.sno.value;
                var form_sno = document.forms[0];
                var input_cno = document.form_name.cno.value;
                var form_cno = document.forms[1];
                if (input_sno != "") {
                    form_sno.submit();
                } else if (input_cno != "") {
                    form_cno.submit();
                } else if (input_cno == "" && input_cno == "") {
                    form_cno.submit();
                }
            })
        })

        function doPrint() {
            bdhtml = window.document.body.innerHTML;
            sprnstr = "<!--startprint-->"; //开始打印标识字符串有17个字符
            eprnstr = "<!--endprint-->"; //结束打印标识字符串
            prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17); //从开始打印标识之后的内容(17为"<!--startprint-->"的长度)
            prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
            window.document.body.innerHTML = prnhtml; //把需要打印的指定内容赋给body.innerHTML
            window.print(); //调用浏览器的打印功能打印指定区域
            window.document.body.innerHTML = bdhtml;//重新给页面内容赋值；
            return false;
        }

    </script>

</head>
<body id="background">

<%@include file="../common/menu.jsp" %>
<div class="manage_title">
    <b>选课信息管理</b>
    <input id="print" type="button" value="打印报表" onclick="doPrint()">
</div>
<div class="search">
    <%--    <div align="center" style="color: grey;font-style: italic;margin-top: 15px">--%>
    <form action="selectClassServlet" method="post" style="display: inline;margin:0px" name="form_id">
        <input type="hidden" name="action" value="findBySno"/>
        学生号：<input class="serach_input" type="text" name="sno" id="sno" value="${param.sno}">
    </form>
    <form action="selectClassServlet" method="post" style="display: inline;margin:30px" name="form_name">
        <input type="hidden" name="action" value="findByCno"/>
        课程号：<input class="serach_input" type="text" name="cno" id="cno" value="${param.cno}">
    </form>
    <input type="button" value="查找" class="submit_btn">
</div>

<div class="form_show">
    <div align="center">
        <table>
            <tr>
                <td>学生号</td>
                <td>课程号</td>
                <td>教工号</td>
                <td>成绩</td>
                <c:if test="${sessionScope.manager.type==1}">
                    <td>教师操作</td>
                </c:if>
                <c:if test="${sessionScope.manager.type==2}">
                    <td><a class="add" href="page/edit_page/Sct_edit.jsp">添加信息</a></td>
                </c:if>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="sct">
                <tr>
                    <td>${sct.sno}</td>
                    <td>${sct.cno}</td>
                    <td>${sct.tno}</td>
                    <td>${sct.grade}</td>
                    <c:if test="${sessionScope.manager.type==2}">
                        <td>
                            <a class="update"
                               href="selectClassServlet?action=getSct&id=${sct.sct_no}&pageNo=${requestScope.page.pageNo}">修改</a>&nbsp;&nbsp;&nbsp;
                            <a class="delete"
                               href="selectClassServlet?action=delete&id=${sct.sct_no}&pageNo=${requestScope.page.pageNo}">删除</a>
                        </td>
                    </c:if>
                    <c:if test="${sessionScope.manager.type==1}">
                        <td>
                            <a class="update_1"
                               href="selectClassServlet?action=getSct&id=${sct.sct_no}&pageNo=${requestScope.page.pageNo}">修改成绩</a>&nbsp;&nbsp;&nbsp;
                        </td>
                    </c:if>
                </tr>
            </c:forEach>

        </table>

        <c:if test="${empty requestScope.page.items}">
            <div id="notfound_info">
                没有查询到符合信息的选课信息！
            </div>
        </c:if>

    </div>
</div>
<%@include file="../common/page_isolate.jsp" %>
<%@include file="../common/foot.jsp" %>
</body>
</html>

<div hidden>
    <!--startprint-->
    <div class="form_show">
        <div align="center">
            <h3 align="center">选课信息</h3>
            <table>
                <tr>
                    <td>学生号</td>
                    <td>课程号</td>
                    <td>教工号</td>
                    <td>成绩</td>
                </tr>
                <c:forEach items="${requestScope.page.items}" var="sct">
                    <tr>
                        <td>${sct.sno}</td>
                        <td>${sct.cno}</td>
                        <td>${sct.tno}</td>
                        <td>${sct.grade}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <!--endprint-->
</div>

