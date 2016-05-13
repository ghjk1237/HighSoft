<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
<script src="<%=request.getContextPath()%>/BJUI/js/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/BJUI/js/jquery.cookie.js"></script>
<script src="<%=request.getContextPath()%>/js/sha256.js"></script>
<link href="<%=request.getContextPath()%>/BJUI/themes/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
* {font-family: "Verdana", "Tahoma", "Lucida Grande", "Microsoft YaHei", "Hiragino Sans GB", sans-serif;}
body {
    background-color:#d6e4ed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
}
a:link {color: #285e8e;}
.main_box {
    position: absolute; top:50%; left:50%; margin-top:-200px; margin-left: -350px; padding: 0px; width:700px; height:300px;
    background: rgba(255,255,255,0.5); border: 1px #DDD solid;
    border-radius: 5px;
    -webkit-box-shadow: 1px 5px 8px #888888; 
    -moz-box-shadow: 1px 5px 8px #888888; 
    box-shadow: 1px 5px 8px #888888;
}
.main_box .setting {position: absolute; top: 5px; right: 10px; width: 10px; height: 10px;}
.main_box .setting a {color: #FF6600;}
.main_box .setting a:hover {color: #555;}
.login_logo {margin-bottom: 1px; height: 90px; text-align: left;background-color:white;}
.login_logo img {height: 90px;}
.login_msg {text-align: center; font-size: 16px;}
.login_form {padding-top: 60px; font-size: 16px;align: top;}
.login_box .form-control {display: inline-block; *display: inline; zoom: 1; width: auto; font-size: 18px;}
.login_box .form-control.x319 {width: 200px;}
.login_box .form-control.x164 {width: 164px;}
.login_box .form-group {margin-bottom: 12px;}
.login_box .form-group label.t {width: 110px; text-align: right; cursor: pointer;}
.login_box .form-group label.t2 {width: 150px; text-align: right; cursor: pointer;}
.login_box .form-group.space {padding-top: 10px; border-top: 1px #FFF dotted;}
.login_box .form-group img {margin-top: 1px; height: 32px; vertical-align: top;}
.login_box .m {cursor: pointer;}
.bottom {width: 100%; height: 60px; position: absolute; bottom: 0px; background: #005f97;
text-align: center; font-size: 16px;padding: 20px;
}
.login_img {float:left;}
</head>
<body>
<!--[if lte IE 7]>
<style type="text/css">
#errorie {position: fixed; top: 0; z-index: 100000; height: 30px; background: #FCF8E3;}
#errorie div {width: 900px; margin: 0 auto; line-height: 30px; color: orange; font-size: 14px; text-align: center;}
#errorie div a {color: #459f79;font-size: 14px;}
#errorie div a:hover {text-decoration: underline;}
</style>
<!--[if lte IE 7]>
    <div id="errorie"><div>您还在使用老掉牙的IE，正常使用系统前请升级您的浏览器到 IE8以上版本 <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a href="http://down.tech.sina.com.cn/content/40975.html" target="_blank">谷歌 Chrome</a></div></div>
<![endif]-->
<div class="login_logo">
    <img src="<%=request.getContextPath()%>/images/logo.png" >
</div>
<div class="main_box">
	<div class="login_box">
        <div class="login_img">
            <img src="<%=request.getContextPath()%>/images/BI.png" >
        </div>
        <div class="login_form">            
    		<form action="system/user/userAction!login.action" id="login_form" method="post">
    			<div class="form-group">
    				<label for="code" class="t">用户名：</label> 
    				<input id="code" name="code" type="text" class="form-control x319 in" autocomplete="off">
    			</div>
    			<div class="form-group">
    				<label for="password" class="t">密　码：</label>
    				<input id="password" name="password" type="password" class="form-control x319 in">
    			</div>
    			<!--  
    			<div class="form-group">
                    <label class="t"></label>
                    <label for="remember" class="m">
                    <input id="remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
    			</div>
    			-->
    			<div class="form-group space">　　　
    				<input type="submit" id="login_ok" value="&nbsp;&nbsp;登&nbsp;&nbsp;&nbsp;录&nbsp;&nbsp;&nbsp;" class="btn btn-primary btn-lg">&nbsp;&nbsp;
    				<input type="reset" value="&nbsp;&nbsp;重&nbsp;&nbsp;&nbsp;置&nbsp;&nbsp;&nbsp;" class="btn btn-default btn-lg">
    			</div>
    		</form>
        </div>
	</div>
</div>
<div class="bottom">Copyright &copy; 2016 - 2017 高软软件</div>
</body>
</html>
