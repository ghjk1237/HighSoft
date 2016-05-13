<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
</script>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="market/rygz/admissionRecAction!importFromHis.action" method="post">
        <input type="hidden" name="pageSize" value="${recList.pageSize}" />
        <input type="hidden" name="pageCurrent" value="${recList.pageCurrent}" />        
        <div class="bjui-searchBar">
            <label>开始日期：</label>  
            <input type="text" name="ksrq" id="dialog_ksrq" value="<fmt:formatDate value='${admissionRec.ksrq}' pattern='yyyy-MM-dd'/>" data-toggle="datepicker" data-rule="required" size="16">&nbsp;&nbsp;
            <label>结束日期：</label>
        	<input type="text" name="jzrq" id="dialog_jzrq" value="<fmt:formatDate value='${admissionRec.jzrq}' pattern='yyyy-MM-dd'/>" data-toggle="datepicker" data-rule="required" size="16">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent">
	<table id="reclist" class="table table-bordered" data-selected-multi="false" data-width="100%"
	    data-toggle="tablefixed" data-nowrap="true">
		<thead>
		<tr>
			<th>住院号</th>
			<th>患者姓名</th>
			<th>性别</th>
			<th>入院病区</th>
			<th>入院科室</th>
			<th>入院日期</th>
			<th>入区日期</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="reclist" items="${recList.rows}">
		<tr>
			<td>${reclist.blh}</td>
			<td>${reclist.hzxm}</td>
			<td>${reclist.sex}</td>
			<td>${reclist.bqmc}</td>
			<td>${reclist.ksmc}</td>
			<td><fmt:formatDate value='${reclist.ryrq}' pattern='yyyy-MM-dd'/></td>
			<td><fmt:formatDate value='${reclist.rqrq}' pattern='yyyy-MM-dd'/></td>
			<td>${reclist.brzt}</td>
			<td>
				<a href="market/rygz/admissionRecAction!loadFromHis.action?zdh=${reclist.zdh}" class="btn btn-default" data-toggle="dialog" data-width="700" data-height="430" data-id="dialog-edit" data-mask="true" data-on-close="doc_dialog_close">录入住院单</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class="bjui-pageFooter">
${recList.pageSize}
    <div class="pagination-box pull-left" data-toggle="pagination" 
        data-total="${recList.total}" data-page-size="10" data-page-current="${recList.pageCurrent}">
    </div>
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>

