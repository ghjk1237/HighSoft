<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="system/user/userAction!list.action" method="post">
        <input type="hidden" name="pageSize" value="${userList.pageSize}">
        <input type="hidden" name="pageCurrent" value="${userList.pageCurrent}">
    </form>
	<a href="system/user/add.jsp" class="btn btn-default" data-toggle="dialog" data-width="750" data-height="290" data-id="dialog-add" data-mask="true" data-on-close="doc_dialog_close">添加用户</a>
</div>
<div class="bjui-pageContent">
	<table id="userlist" class="table table-bordered" data-selected-multi="false" data-width="100%"
	    data-toggle="tablefixed" data-nowrap="true">
		<thead>
		<tr>
			<th>编码</th>
			<th>名称</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>是否启用</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="userlist" items="${userList.rows}">
		<tr>
			<td>${userlist.code}</td>
			<td>${userlist.name}</td>
			<td>${userlist.sex}</td>
			<td><fmt:formatDate value="${userlist.birth}" pattern="yyyy-MM-dd"/></td>
			<td>
				<c:if test="${userlist.enable==true}">是</c:if>
		   		<c:if test="${userlist.enable==false}">否</c:if>
			</td>
			<td>
				<a href="system/user/userAction!detail2.action?id=${userlist.id}" class="btn btn-default" data-toggle="dialog" data-width="750" data-height="290" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">编辑用户</a>
				<a href="system/role/roleAction!listByUserId.action?userId=${userlist.id}" class="btn btn-default" data-toggle="dialog" data-width="350" data-height="450" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">编辑角色</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<div class="bjui-pageFooter">
    <div class="pagination-box pull-left" data-toggle="pagination" data-total="${userList.total}" data-page-size="${userList.pageSize}" data-page-current="${userList.pageCurrent}"></div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>