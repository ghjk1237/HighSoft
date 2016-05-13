<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
submit = function() {
    var tree = $.fn.zTree.getZTreeObj("ztreeMenu");
	var userList= tree.getCheckedNodes(true);
	var users = "";
	$.each(userList, function() {
	    users = users + this.id + ",";
	});
	if (users.length>0) {
		users = users.substr(0,users.length-1);
	}
    $.ajax({ 
	    url:'<%=request.getContextPath()%>/market/group/groupAction!updateUser.action',   
	    type:'post',
	    dataType:"json",    
	    data:{id:"${groupId}",users:users},   
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
    <c:forEach var="list" items="${groupuser.rows}">
		<li data-id="${list.userId}" data-pid="0" data-checked="${list.checked}">${list.userName}</li>	
	</c:forEach>
    </ul>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default" onclick="submit()">保存</button></li>
    </ul>
</div>