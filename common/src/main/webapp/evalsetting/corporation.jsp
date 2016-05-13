<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="evalsetting/bicorporationAction!list.action" method="post">
        <input type="hidden" name="pageSize" value="${corlist.pageSize}">
        <input type="hidden" name="pageCurrent" value="${corlist.pageCurrent}">
    </form>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
</div>
<div class="bjui-pageContent">
	<table id="corlist" name="rolelist" class="table table-bordered" data-selected-multi="false" data-width="100%"
	    data-toggle="tablefixed"  data-nowrap="true">
		<thead>
		<tr>
			<th>机构代码</th>
			<th>机构名称</th>
			<th>医疗机构名称</th>
			<th>医疗机构编码</th>			
			<th>是否有效</th>
			<th>备注</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="cor" items="${corlist.rows}">
		<tr>			
			
			<td>${cor.corpId}</td>
			<td>${cor.hospId}</td>
			<td>${cor.hospName}</td>		
			<td>${cor.corpId}</td>									
			<td>
				<c:if test="${cor.isValid==true}">是</c:if>
		   		<c:if test="${cor.isValid==false}">否</c:if>
			</td>
			<td>
				<a href="system/role/roleAction!detail2.action?id=${cor.corpId}" class="btn btn-default" data-toggle="dialog" data-width="700" data-height="250" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">编辑</a>
				<a href="menuAction!listByRoleId.action?roleId=${cor.corpId}" class="btn btn-default" data-toggle="dialog" data-width="350" data-height="450" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">权限</a>
			</td>
			<td>${cor.memo}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="bjui-pageFooter">
    <div class="pagination-box pull-left" data-toggle="pagination" data-total="${corlist.total}" data-page-size="${corlist.pageSize}" data-page-current="${corlist.pageCurrent}"></div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>

