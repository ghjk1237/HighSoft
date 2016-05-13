<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="market/group/groupAction!list.action" method="post">
        <input type="hidden" name="pageSize" value="${coworkdoclist.pageSize}">
        <input type="hidden" name="pageCurrent" value="${coworkdoclist.pageCurrent}">
    </form>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	<a href="market/hzys/add.jsp" class="btn btn-default" data-toggle="dialog" data-width="720" data-height="220" data-id="dialog-add" data-mask="true" data-on-close="doc_dialog_close">添加合作医生</a>
</div>
<div class="bjui-pageContent">
	<table id="coworkdoclist" name="coworkdoclist" class="table table-bordered" data-selected-multi="false" data-width="100%"
	    data-toggle="tablefixed"  data-nowrap="true">
		<thead>
		<tr>
			<th>合作医生编码</th>
			<th>合作医生姓名</th>
			<th>引入人员</th>
			<th>引入日期</th>
			<th>所属单位</th>			
			<th>合作状态</th>
			<th>终止日期</th>		
			<th>操作</th>	
		</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${coworkdoclist.rows}">
		<tr>
			<td>${list.code}</td>
			<td>${list.name}</td>
			<td>${list.userName}</td>
			<td><fmt:formatDate value="${list.beginDate}" pattern="yyyy-MM-dd"/></td>
			<td>${list.compName}</td>
			<td>
				<c:if test="${list.enable==true}">是</c:if>
		   		<c:if test="${list.enable==false}">否</c:if>
			</td>
			<td><fmt:formatDate value="${list.endDate}" pattern="yyyy-MM-dd"/></td>
			<td>
				<a href="market/hzys/coworkDocAction!detail.action?id=${list.id}" class="btn btn-default" data-toggle="dialog" data-width="700" data-height="220" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">编辑</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="bjui-pageFooter">
    <div class="pagination-box pull-left" data-toggle="pagination" data-total="${coworkdoclist.total}" data-page-size="${coworkdoclist.pageSize}" data-page-current="${coworkdoclist.pageCurrent}"></div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>

