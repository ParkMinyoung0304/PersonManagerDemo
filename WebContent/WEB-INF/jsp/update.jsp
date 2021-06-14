<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工职位信息变动</title>
    
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
   <h1>修改界面</h1>
    <h2>欢迎！！！${sessionScope.user }</h2>
    <hr />
    <form action="person/updateOne.action">
        <input type="hidden" name="uid" value="${person.uid}">
      name：<input type="text" value="${person.name}" name="name"><br />
      idcard：<input type="text" value="${person.idcard}" name="idcard"><br />
      phone：<input type="text" value="${person.phone}" name="phone"><br />
      sex：<input type="text" value="${person.sex}" name="sex"><br />
      email：<input type="text" value="${person.email}" name="email"><br />
      classname：<input type="text" value="${person.classname}" name="classname" list="classname">
      		  <datalist id="classname" > 
               <option value="董事会"> 董事会
               <option value="市场部"> 市场部
               <option value="采购部"> 采购部
               <option value="财务部"> 财务部
               <option value="人事部"> 人事部
             </datalist> <br />
      leadername：<input type="text" value="${person.leadername}" name="leadername"><br />
      typename：<input type="text" value="${person.typename}" name="typename"><br />
      access_permission：<input type="text" value="${person.access_permission}" name="access_permission"><br />
             </select> <br />
          <input type="submit" value="修改员工信息">   
    </form>  </body>
</html>
