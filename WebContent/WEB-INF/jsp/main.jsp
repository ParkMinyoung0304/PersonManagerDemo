<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工信息界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	function setAll() {
         var sids = document.getElementsByName("sid");
         for (var i = 0; i < sids.length; i++) {
             sids[i].checked = true;
         }
     }
	function setNo() {
         var sids = document.getElementsByName("sid");
         for (var i = 0; i < sids.length; i++) {
             sids[i].checked = false;
         }
     }
	function setPress(){
		if(document.getElementsByName("press")[0].checked){
			setAll();
		}else{
			setNo();
		}
	}
	</script>

  </head>
  
  <body>
    <h1>主界面</h1>
    <h2>欢迎！！！${sessionScope.user } <a href="<%=basePath%>">登出</a></h2>
    <hr />
    <c:if test="${hr_permission=='1'}"><a href="person/addOne.action?flag=1">添加</a></c:if>
    <form action="person/search.action">搜索：
    <select name="filter">
               <option value="uid"> uid
               <option value="name"> name
               <option value="idcard"> idcard
               <option value="phone"> phone
               <option value="sex"> sex
               <option value="email"> email
               <option value="classname"> classname
               <option value="leadername"> leadername
               <option value="typename"> typename
             </select>
             <input type="text" name="keyword">   <input type="submit" value="立即搜索"><br />
    </form>
    
    <form action="person/delAll.action">
      <table border="1">
        <tr>
        <td><input type="checkbox" name="press" onclick="setPress()"></td>
          <td>uid</td>
          <td>name</td>
          <td>idcard</td>
          <td>phone</td>
          <td>sex</td>
          <td>email</td>
          <td>classname</td>
          <td>leadername</td>
          <td>typename</td>
          <td>操作</td>
        </tr>
        <c:forEach items="${lstperson}" var="person">
        <tr>
        <td><input type="checkbox" value="${person.uid }" name="sid"> </td>
          <td>${person.uid }</td>
          <td>${person.name }</td>
          <td>${person.idcard }</td>
          <td>${person.phone }</td>
          <td>${person.sex }</td>
          <td>${person.email }</td>
          <td>${person.classname }</td>
          <td>${person.leadername }</td>
          <td>${person.typename }</td>
          <td><c:if test="${hr_permission=='1'}"><a href="person/findById.action?sid=${person.uid}">修改</a> 
          <a href="person/delOne.action?sid=${person.uid}">删除</a></c:if> </td>
        </tr>
        </c:forEach>
      </table>
      <c:if test="${hr_permission=='1'}"><input type="submit" value="批量删除"></c:if>
    </form>
  </body>
</html>
