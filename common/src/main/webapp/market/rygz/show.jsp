<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="market/group/groupAction!list.action" method="post">
        <input type="hidden" name="pageSize" value="${groplist.pageSize}">
        <input type="hidden" name="pageCurrent" value="${groplist.pageCurrent}">
    </form>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	<a href="market/group/add.jsp" class="btn btn-default" data-toggle="dialog" data-width="700" data-height="200" data-id="dialog-add" data-mask="true" data-on-close="doc_dialog_close">添加</a>
</div>
<div class="bjui-pageContent">
	<table id="rolelist" name="rolelist" class="table table-bordered" data-selected-multi="false" data-width="100%"
	    data-toggle="tablefixed"  data-nowrap="true">
		<thead>
		<tr>
			<th>住院号</th>
			<th>患者姓名</th>
			<th>入院病区</th>
			<th>入院科室</th>
			<th>入院日期</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${groplist.rows}">
		<tr>
			<td>${list.code}</td>
			<td>${list.name}</td>
			<td>
				<c:if test="${list.enable==true}">是</c:if>
		   		<c:if test="${list.enable==false}">否</c:if>
			</td>
			<td>
				<a href="market/group/groupAction!detail.action?id=${list.id}" class="btn btn-default" data-toggle="dialog" data-width="700" data-height="250" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">编辑</a>
				<a href="market/group/groupAction!listUser.action?id=${list.id}" class="btn btn-default" data-toggle="dialog" data-width="350" data-height="450" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">成员</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="bjui-pageFooter">
    <div class="pagination-box pull-left" data-toggle="pagination" data-total="${groplist.total}" data-page-size="${groplist.pageSize}" data-page-current="${groplist.pageCurrent}"></div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>

