<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="market/group/groupAction!selectMem.action" method="post">
        <input type="hidden" name="pageSize" value="${memList.pageSize}">
        <input type="hidden" name="pageCurrent" value="${memList.pageCurrent}">
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
			<th>编码</th>
			<th>姓名</th>					
			<th>状态</th>
			<th>小组</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${memList.rows}">
		<tr>
			<td>${list.userCode}</td>
			<td>${list.userName}</td>
			<td>
				<c:if test="${list.checked==true}">是</c:if>
		   		<c:if test="${list.checked==false}">否</c:if>
			</td>
			<td>${list.groupName}</td>
			<td>
			    <a href="javascript:;" data-toggle="lookupback" data-args="{userId:'${list.userId}', userName:'${list.userName}'}" class="btn btn-blue" title="选择本项" data-icon="check">选择</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<div class="bjui-pageFooter">
    <div class="pagination-box pull-left" data-toggle="pagination" data-total="${memList.total}" data-page-size="${memList.pageSize}" data-page-current="${memList.pageCurrent}"></div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>