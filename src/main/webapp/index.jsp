<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello word</title>
</head>
<body>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%=path%><br/>
 <%=basePath%><br/>
<h1>你好</h1>

<a href="hello3.do">hello.do  @RequestMapping("/hello")</a><br/>
<a href="/hello.do">/hello.do @RequestMapping("/hello")</a><br/>

 <a href="userCtrl/hello.do">userCtrl/hello.do  @RequestMapping("/userCtrl") @RequestMapping("/hello")  </a><br/>
 <a href="<%=basePath%>WebRoot/Pages/jingtai/jingtai.html">静态页面获取</a><br/>

 
 <a href="userCtrl/addUser.do">无返回值</a>userCtrl/addUser.do无返回值<br/>
 后台返回值ss${message}，ss2 ${ss2}</br>
 <form action="userCtrl/addUser.do" method="post">
        用户名：<input type="text" name="username"/><br/>
       年    龄：<input type="text" name="age"/><br/>
        密&nbsp;&nbsp;码：<input type="password" name="password"/>
        
        <input type="submit" value="登陆"/>
        <a href="regist">注册</a>
    </form>
 
<form action="userCtrl/upload.do" method="post" enctype="multipart/form-data">  
<input type="file" name="file" /> 
<input type="submit" value="Submit" />
</form></br>
 上传路径${fileUrl}
</body>
</html>