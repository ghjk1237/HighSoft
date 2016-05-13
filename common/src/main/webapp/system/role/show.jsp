<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="system/role/roleAction!list.action" method="post">
        <input type="hidden" name="pageSize" value="${roleList.pageSize}">
        <input type="hidden" name="pageCurrent" value="${roleList.pageCurrent}">
    </form>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	<a href="system/role/add.jsp" class="btn btn-default" data-toggle="dialog" data-width="700" data-height="250" data-id="dialog-add" data-mask="true" data-on-close="doc_dialog_close">添加角色</a>
</div>
<div class="bjui-pageContent">
	<table id="rolelist" name="rolelist" class="table table-bordered" data-selected-multi="false" data-width="100%"
	    data-toggle="tablefixed"  data-nowrap="true">
		<thead>
		<tr>
			<th>角色编码</th>
			<th>角色名称</th>
			<th>是否启用</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="rolelist" items="${roleList.rows}">
		<tr>
			<td>${rolelist.code}</td>
			<td>${rolelist.name}</td>
			<td>
				<c:if test="${rolelist.enable==true}">是</c:if>
		   		<c:if test="${rolelist.enable==false}">否</c:if>
			</td>
			<td>
				<a href="system/role/roleAction!detail2.action?id=${rolelist.id}" class="btn btn-default" data-toggle="dialog" data-width="700" data-height="250" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">编辑</a>
				<a href="menuAction!listByRoleId.action?roleId=${rolelist.id}" class="btn btn-default" data-toggle="dialog" data-width="350" data-height="450" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">权限</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="bjui-pageFooter">
    <div class="pagination-box pull-left" data-toggle="pagination" data-total="${roleList.total}" data-page-size="${roleList.pageSize}" data-page-current="${roleList.pageCurrent}"></div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>

