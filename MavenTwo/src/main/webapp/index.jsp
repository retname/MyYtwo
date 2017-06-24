<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>

<script type="text/javascript" src="lib/jquery-1.8.3.min.js"></script>

<script type="text/javascript">



    function first(index) {

        alert(index);
        window.location.href="<%=path%>/empServlet?pageIndex="+0+"&selected="+$("#selected").val()+"&name="+ $("#name").val();
    }
    function  end(index) {


        window.location.href="<%=path%>/empServlet?pageIndex="+index+"&selected="+$("#selected").val()+"&name="+ $("#name").val();
    }

    function last(index) {


        if(index+1==0){
            alert("已经是第一页了");
            return;
        }else{
            alert(index);
            window.location.href="<%=path%>/empServlet?pageIndex="+index+"&selected="+$("#selected").val()+"&name="+ $("#name").val();
        }
    }
    function down(index,allindex) {
         if(index+1>allindex) {
             alert("已经是最后一页了");
             return;
         }else{
             alert(index);
             window.location.href="<%=path%>/empServlet?pageIndex="+index+"&selected="+$("#selected").val()+"&name="+ $("#name").val();
         }
    }
</script>


<style>
     #mydiv{
         margin: auto 0px;
     }
    td{

        border: solid 1px red;
        text-align: center;

    }
    #mytable{

        margin: auto 0px;
    }

    #all{
        width: 800px;
        margin-left: 600px;

    }

    #mypage{
        margin-left: 550px;
    }
</style>
<body>


<div id="all">


<h2>北大青鸟人员信息管理表</h2>

<form action="empServlet?select=2" method="post">

    <input id="name" type="text" name="name" value="${name}">
    <select name="selected" id="selected">
            <option value="0">请选择</option>
            <c:forEach items="${branch}" var="item">
                <option name="selected" value="${item.branchId}"
                        <c:if test="${item.branchId==blanid}">selected="selected"</c:if>>${item.branchName}</option>
            </c:forEach>
    </select>
    <input type="submit" value="提交">

</form>

<div id="mydiv">
    <table id="mytable">
        <tr>
            <td>员工编号</td>
            <td>员工姓名</td>
            <td>部门名称</td>
        </tr>
        <c:forEach items="${empleall.getAll}" var = "item">
        <tr>
            <td>${item.empId}</td>
            <td>${item.empName}</td>
            <td>${item.branchName}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</div>
<div id="mypage">

    <form action="empServlet" method="post">
        <c:out value="${empleall.pageIndex}"></c:out>
        <c:out value="${empleall.pageAll}"></c:out>
        当前页数/总页数[${empleall.pageIndex+1}/${empleall.pageAll}] &nbsp;&nbsp;<em onclick="javascript:first(${empleall.pageIndex})">首页</em>&nbsp;&nbsp;
        <em onclick="javascript:last(${empleall.pageIndex-1})">上一页</em>&nbsp;&nbsp;
        <em onclick="javascript:down(${empleall.pageIndex+1},${empleall.pageAll})">下一页</em>&nbsp;&nbsp;
        <em onclick="javascript:end(${empleall.pageAll-1})">末页</em>
    </form>

   <h2>文件上传</h2>

    <form method ="post" action ="fileServlet"  enctype ="multipart/form-data">
    选择一个文件：
    <input type ="file" name ="uploadFile"/>
    <BR/> <BR/>
    <input type ="submit"  value ="上传"/>
    </form>



</div>

</body>
</html>
