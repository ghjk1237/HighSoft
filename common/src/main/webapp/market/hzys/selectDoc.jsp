<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="market/hzys/coworkDocAction!selectDoc.action" method="post">
        <input type="hidden" name="pageSize" value="${docList.pageSize}">
        <input type="hidden" name="pageCurrent" value="${docList.pageCurrent}">
        <div class="bjui-searchBar">
            <label>编码：</label><input type="text" name="code" size="10">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a></li>
        </div>
    </form>
</div>
<div class="bjui-pageContent">
	<table id="complist" class="table table-bordered" data-selected-multi="false" data-width="100%"
	    data-toggle="tablefixed" data-nowrap="true">
		<thead>
		<tr>
			<th>合作医生编码</th>
			<th>合作医生姓名</th>
			<th>引入人员</th>
			<th>引入日期</th>			
			<th>合作状态</th>
			<th>终止日期</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${docList.rows}">
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
			    <a href="javascript:;" data-toggle="lookupback" data-args="{docId:'${list.id}', docName:'${list.name}'}" class="btn btn-blue" title="选择本项" data-icon="check">选择</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<div class="bjui-pageFooter">
    <div class="pagination-box pull-left" data-toggle="pagination" data-total="${docList.total}" data-page-size="${docList.pageSize}" data-page-current="${docList.pageCurrent}"></div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>