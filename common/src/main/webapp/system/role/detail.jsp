<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="bjui-pageContent">
    <form id="addrole" action="<%=request.getContextPath()%>/roleAction!add.action" class="pageForm" data-toggle="validate"
        data-callback="submit">
        <input type="hidden" name="id" value="${roleInfo.id}">
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td colspan="2" align="center"><h4>系统角色详情</h4></td>
                </tr>
                <tr>
                    <td>
                        <label for="dialog_code" class="control-label x50">编码：</label>
                        <input type="text" name="code" id="dialog_code" value="${roleInfo.code}" data-rule="required" size="16">
                    </td>
                    <td>
                        <label for="dialog_name" class="control-label x50">名称：</label>
                        <input type="text" name="name" id="dialog_name" value="${roleInfo.name}" data-rule="required" size="16">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dialog_enable" class="control-label x50">启用：</label>
                        <select id="dialog_enable" name="enable" data-toggle="selectpicker">
                            <option value="true" <c:if test="${roleInfo.enable==true}">selected</c:if>>启用</option>
                            <option value="false" <c:if test="${roleInfo.enable==false}">selected</c:if>>停用</option>
                        </select>                       
                    </td>
                    <td>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>        
    </ul>
</div>