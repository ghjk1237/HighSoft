<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
if (request.getSession().getAttribute("user")==null){
    response.sendRedirect("system/common/login.jsp");
}
%>
<!DOCTYPE HTML">
<html lang="zh">
  <head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>My JSP 'index.jsp' starting page</title>
    <jsp:include page="system/common/intoHead.jsp"></jsp:include>
	  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
    <!--[if lte IE 7]>
        <div id="errorie"><div>您还在使用老掉牙的IE，正常使用系统前请升级您的浏览器到 IE8以上版本 <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a href="http://down.tech.sina.com.cn/content/40975.html" target="_blank">谷歌 Chrome</a></div></div>
    <![endif]-->
    <div id="bjui-window">
	    <header id="bjui-header">
	        <jsp:include page="system/common/header.jsp"></jsp:include>
	        <jsp:include page="system/common/menu.jsp"></jsp:include>        
	    </header>
	    <div id="bjui-container">
	        <div id="bjui-leftside">
	            <div id="bjui-sidebar-s">
	                <div class="collapse"></div>
	            </div>
	            <div id="bjui-sidebar">
	                <div class="toggleCollapse"><h2><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h2><a href="javascript:;" class="lock"><i class="fa fa-lock"></i></a></div>
	                <div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">
	                </div>
	            </div>
	        </div>
	        <div id="bjui-navtab" class="tabsPage">
	            <div class="tabsPageHeader">
	                <div class="tabsPageHeaderContent">
	                    <ul class="navtab-tab nav nav-tabs">
	                        <li data-url=""><a href="javascript:;"><span><i class="fa fa-home"></i> #maintab#</span></a></li>
	                    </ul>
	                </div>
	                <div class="tabsLeft"><i class="fa fa-angle-double-left"></i></div>
	                <div class="tabsRight"><i class="fa fa-angle-double-right"></i></div>
	                <div class="tabsMore"><i class="fa fa-angle-double-down"></i></div>
	            </div>
	            <ul class="tabsMoreList">
	                <li><a href="javascript:;">#maintab#</a></li>
	            </ul>
	            <div class="navtab-panel tabsPageContent">
	                <div class="navtabPage unitBox">
	                    <div class="bjui-pageContent" style="background:#FFF;">
	                        Loading...
	                    </div>
	                </div>
	            </div>
	        </div>        
	    </div> 
	    <footer id="bjui-footer">
		</footer>   
    </div>
  </body>
</html>
