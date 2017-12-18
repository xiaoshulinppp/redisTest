<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<body>
    
<%=path%><br/>
 <%=basePath%><br/>
    <form action="login" method="post">
        用户名：<input type="text" name="username"/><br/>
        密&nbsp;&nbsp;码：<input type="password" name="password"/>
        <input type="submit" value="登陆"/>
        <a href="regist">注册</a>
    </form>
    <a href="/WEB-INF/WebRoot/Pages/jingtai.html">静态页面获取</a>
    ${message}
<!-- 输出普通字符 -->  
   ${message } <br/>  
   <!-- 输出List -->  
   <p>书籍列表</p>  
   <c:forEach items="${bookList}" var="node">  
        <c:out value="${node}"></c:out>  
   </c:forEach>  
   <br/>  
   <br/>  
     
   <!-- 输出Map -->  
   <c:forEach items="${map}" var="node">  
        姓名：<c:out value="${node.key}"></c:out>  
        住址：<c:out value="${node.value}"></c:out>  
        <br/>  
   </c:forEach>  
   </br>
   测试request 传志写法是否一样:${requestScope.request}</br>
  hellomodel是否乱码: ${requestScope.key}</br>
  页面获取session：
    ${sessionScope.user.name}</br>
    requestScope.key
     上传路径${fileUrl}
</body>
</html>