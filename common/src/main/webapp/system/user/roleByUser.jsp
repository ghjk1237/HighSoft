<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
submit = function() {
    var tree = $.fn.zTree.getZTreeObj("ztreeMenu");
	var roleList= tree.getCheckedNodes(true);
	var roles = "";
	$.each(roleList, function() {
	    roles = roles + this.id + ",";
	});
	if (roles.length>0) {
		roles = roles.substr(0,roles.length-1);
	}
    $.ajax({ 
	    url:'<%=request.getContextPath()%>/system/user/userAction!updateRole.action',   
	    type:'post',
	    dataType:"json",    
	    data:{id:"${id}",roles:roles},   
	    async : false, //默认为true 异步   
	    error:function(){   
	       alert('error'); 			        
	    },   
	    success:function(json){
	    	$(this).dialog('closeCurrent');
	        $(this).alertmsg('ok', json.msg, {okName:'确定'});
	    }
	});
}	
 
</script>
<div class="bjui-pageContent">
    <ul id="ztreeMenu" class="ztree" data-toggle="ztree" data-check-enable=true data-chk-style="checkbox">
    <c:forEach var="list" items="${roles.rows}">
		<li data-id="${list.id}" data-pid="0" data-checked="${list.checked}">${list.name}</li>	
	</c:forEach>
    </ul>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default" onclick="submit()">保存</button></li>
    </ul>
</div>