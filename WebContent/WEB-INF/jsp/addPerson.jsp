<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>入职办理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h1>添加界面</h1>
    <h2>欢迎！！！${sessionScope.user }</h2>
    <hr />
    <form action="person/addOne.action">
        <input type="hidden" name="flag" value="2">
      uid：<input type="text" name="uid"><br />
      name：<input type="text" name="name"><br />
      idcard：<input type="text" name="idcard"><br />
      phone：<input type="text" name="phone"><br />
      sex：<input type="text" name="sex"><br />
      email：<input type="text" name="email"><br />
      classname：<select name="classname">
               <option value="董事会"> 董事会
               <option value="市场部"> 市场部
               <option value="采购部"> 采购部
               <option value="财务部"> 财务部
               <option value="人事部"> 人事部
             </select> <br />
      leadername：<input type="text" name="leadername"><br />
      typename：<input type="text" name="typename"><br />
      access_permission：<input type="text" name="access_permission"><br />

             
          <input type="submit" value="添加员工信息">   
    </form>
  </body>
</html>
