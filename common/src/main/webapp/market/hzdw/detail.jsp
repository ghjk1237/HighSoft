<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
function submit(json) {
    $(this).bjuiajax('ajaxDone', json)
    if (json.success == true) { 
        $(this).dialog('closeCurrent');
        $(this).alertmsg('ok', json.msg, {okName:'确定'});
        $(this).navtab('refresh');        
    } else {
        alert('error');
    }    
}
</script>
<div class="bjui-pageContent">
    <form id="market_group_detail" action="<%=request.getContextPath()%>/market/hzdw/coworkCompAction!edit.action" class="pageForm" data-toggle="validate"
        data-callback="submit">
        <input type="hidden" name="id" value="${coworkComp.id}">
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td>
                        <label for="dialog_code" class="control-label x80">编码：</label>
                        <input type="text" name="code" id="dialog_code" value="${coworkComp.code}" data-rule="required" size="16">
                    </td>
                    <td>
                        <label for="dialog_name" class="control-label x80">名称：</label>
                        <input type="text" name="name" id="dialog_name" value="${coworkComp.name}" data-rule="required" size="16">
                    </td>
                </tr>                
                <tr>
                    <td>
                        <input type="hidden" name="userId" value="${coworkComp.userId}">
                        <label for="dialog_userName" class="control-label x80">引入人员：</label>
                        <input type="text" name="userName" id="dialog_ksrq" value="${coworkComp.userName}" data-rule="required" size="16"
                            data-toggle="lookup" data-url="<%=request.getContextPath()%>/system/user/userAction!selectUser.action"
                            data-group="">
                    </td>
                    <td>
                        <label for="dialog_ksrq" class="control-label x80">引入日期：</label>
                        <input type="text" name="beginDate" id="dialog_ksrq" value="<fmt:formatDate value='${coworkComp.beginDate}' pattern='yyyy-MM-dd'/>" data-toggle="datepicker" data-rule="required" size="16">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label for="dialog_enable" class="control-label x80">启用：</label>
                        <select id="dialog_enable" name="enable" data-toggle="selectpicker">
                            <option value="true" <c:if test="${coworkComp.enable==true}">selected</c:if>>启用</option>
                            <option value="false" <c:if test="${coworkComp.enable==false}">selected</c:if>>停用</option>
                        </select>                       
                    </td>
                    <td>
                    	<label for="dialog_zzrq" class="control-label x80">终止日期：</label>
                        <input type="text" name="endDate" id="dialog_zzrq" value="<fmt:formatDate value='${coworkComp.endDate}' pattern='yyyy-MM-dd'/>" data-toggle="datepicker" data-rule="required" size="16">
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">保存</button></li>
    </ul>
</div>