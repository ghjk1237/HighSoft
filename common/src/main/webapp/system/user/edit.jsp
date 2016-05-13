<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function submit(json) {
    $(this).bjuiajax('ajaxDone', json)
    if (json.success == true) { 
        $(this).dialog('closeCurrent');
        $(this).alertmsg('ok', json.msg, {okName:'确定'});       
    } else {
        alert('error');
    }    
}
</script>
<div class="bjui-pageContent">
    <form id="addrole" action="<%=request.getContextPath()%>/system/user/userAction!update.action" class="pageForm" data-toggle="validate"
        data-callback="submit">
        <input type="hidden" name="id" value="${userInfo.id}">
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td colspan="2" align="center"><h2>编辑系统用户</h2></td>
                </tr>
                <tr>
                    <td>
                        <label for="dialog_code" class="control-label x80">编码：</label>
                        <input type="text" name="code" id="dialog_code" value="${userInfo.code}" data-rule="required" size="16">
                    </td>
                    <td>
                        <label for="dialog_name" class="control-label x80">姓名：</label>
                        <input type="text" name="name" id="dialog_name" value="${userInfo.name}" data-rule="required" size="16">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dialog_sex" class="control-label x80">性别：</label>
                        <select id="dialog_sex" name="sex" data-toggle="selectpicker">
                            <option value="男"<c:if test="${userInfo.sex=='男'}">selected</c:if>>男</option>
                            <option value="女"<c:if test="${userInfo.sex=='女'}">selected</c:if>>女</option>
                        </select> 
                    </td>
                    <td>
                        <label for="dialog_birth" class="control-label x80">出生日期：</label>
                        <input type="text" name="birth" value="<fmt:formatDate value='${userInfo.birth}' pattern='yyyy-MM-dd'/>" id="dialog_birth" data-toggle="datepicker" data-rule="required" size="16">                        
                    </td>
                </tr>                
                <tr>
                    <td>
                    	<label for="dialog_password" class="control-label x80">密码：</label>
                        <input type="password" name="password" id="dialog_password" value="${userInfo.password}" data-rule="required" size="16">
                    </td>
                    <td>
                        <label for="dialog_enable" class="control-label x80">启用：</label>
                        <select id="dialog_enable" name="enable" data-toggle="selectpicker">
                            <option value="true" <c:if test="${userInfo.enable==true}">selected</c:if>>启用</option>
                            <option value="false" <c:if test="${userInfo.enable==false}">selected</c:if>>停用</option>
                        </select>                       
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