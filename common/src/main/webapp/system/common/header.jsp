<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="bjui-navbar-header">
    <button type="button" class="bjui-navbar-toggle btn-default" data-toggle="collapse" data-target="#bjui-navbar-collapse">
        <i class="fa fa-bars"></i>
    </button>            
</div>
<nav id="bjui-navbar-collapse">
    <ul class="bjui-navbar-right">
    	<li><a href="#">欢迎您,${sessionScope.user.code}|${sessionScope.user.name}</a></li>
        <li class="datetime"><div><span id="bjui-date"></span> <span id="bjui-clock"></span></div></li>
        <!-- <li><a href="#">消息 <span class="badge">4</span></a></li> -->
        
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">我的账户 <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="system/user/userAction!detail2.action?id=${sessionScope.user.id}" data-toggle="dialog" data-id="changepwd_page" data-mask="true" data-width="600" data-height="260">&nbsp;<span class="glyphicon glyphicon-lock"></span> 修改密码&nbsp;</a></li>
                <li class="divider"></li>
                <li><a href="system/user/userAction!logout.action?id=${sessionScope.user.id}" class="red">&nbsp;<span class="glyphicon glyphicon-off"></span> 注销登陆</a></li>
            </ul>
        </li>
        <li class="dropdown"><a href="#" class="dropdown-toggle theme blue" data-toggle="dropdown" title="切换皮肤">切换皮肤</a>
            <ul class="dropdown-menu" role="menu" id="bjui-themes">
                <li><a href="javascript:;" class="theme_default" data-toggle="theme" data-theme="default">&nbsp;<i class="fa fa-tree"></i> 黑白分明&nbsp;&nbsp;</a></li>
                <li><a href="javascript:;" class="theme_orange" data-toggle="theme" data-theme="orange">&nbsp;<i class="fa fa-tree"></i> 橘子红了</a></li>
                <li><a href="javascript:;" class="theme_purple" data-toggle="theme" data-theme="purple">&nbsp;<i class="fa fa-tree"></i> 紫罗兰</a></li>
                <li class="active"><a href="javascript:;" class="theme_blue" data-toggle="theme" data-theme="blue">&nbsp;<i class="fa fa-tree"></i> 天空蓝</a></li>
                <li><a href="javascript:;" class="theme_green" data-toggle="theme" data-theme="green">&nbsp;<i class="fa fa-tree"></i> 绿草如茵</a></li>
            </ul>
        </li>
    </ul>
</nav>
