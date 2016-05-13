<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="market/group/groupAction!list.action" method="post">
        <input type="hidden" name="pageSize" value="${coworkcomplist.pageSize}">
        <input type="hidden" name="pageCurrent" value="${coworkcomplist.pageCurrent}">
    </form>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	<a href="market/hzdw/add.jsp" class="btn btn-default" data-toggle="dialog" data-width="720" data-height="200" data-id="dialog-add" data-mask="true" data-on-close="doc_dialog_close">添加合作单位</a>
</div>
<div class="bjui-pageContent">
	<table id="coworkcomplist" name="coworkcomplist" class="table table-bordered" data-selected-multi="false" data-width="100%"
	    data-toggle="tablefixed"  data-nowrap="true">
		<thead>
		<tr>
			<th>合作单位编码</th>
			<th>合作单位名称</th>
			<th>引入人员</th>
			<th>引入日期</th>			
			<th>合作状态</th>
			<th>终止日期</th>		
			<th>操作</th>	
		</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${coworkcomplist.rows}">
		<tr>
			<td>${list.code}</td>
			<td>${list.name}</td>
			<td>${list.userName}</td>
			<td><fmt:formatDate value="${list.beginDate}" pattern="yyyy-MM-dd"/></td>
			<td>
				<c:if test="${list.enable==true}">是</c:if>
		   		<c:if test="${list.enable==false}">否</c:if>
			</td>
			<td><fmt:formatDate value="${list.endDate}" pattern="yyyy-MM-dd"/></td>
			<td>
				<a href="market/hzdw/coworkCompAction!detail.action?id=${list.id}" class="btn btn-default" data-toggle="dialog" data-width="750" data-height="200" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">编辑</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="bjui-pageFooter">
    <div class="pagination-box pull-left" data-toggle="pagination" data-total="${coworkcomplist.total}" data-page-size="${coworkcomplist.pageSize}" data-page-current="${coworkcomplist.pageCurrent}"></div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>

