<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <form id="market_rygz_add" action="<%=request.getContextPath()%>/market/rygz/admissionRecAction!add.action" class="pageForm" data-toggle="validate"
        data-callback="submit">
        <table class="table table-condensed table-hover">
            <input type="text" name="cardno" id="dialog_cardno" value="${admissRec.cardno}" size="16" readonly>
            <input type="text" name="brzt" id="dialog_brzt" value="${admissRec.brzt}" size="16" readonly>
            <tbody>
                <tr>
                    <td>
                        <label for="dialog_zdh" class="control-label x80">账单号：</label>
                        <input type="text" name="zdh" id="dialog_zdh" value="${admissRec.zdh}" size="16" readonly>
                    </td>
                    <td>
                        <label for="dialog_blh" class="control-label x80">住院号：</label>
                        <input type="text" name="blh" id="dialog_blh" value="${admissRec.blh}" size="16" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dialog_hzxm" class="control-label x80">患者姓名：</label>
                        <input type="text" name="hzxm" id="dialog_hzxm" value="${admissRec.hzxm}" size="16" readonly>
                    </td>
                    <td>
                        <label for="dialog_sex" class="control-label x80">性别：</label>
                        <input type="text" name="sex" id="dialog_sex" value="${admissRec.sex}" size="16" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="ybdm" value="${admissRec.ybdm}">
                        <label for="dialog_ybmc" class="control-label x80">收费类型：</label>
                        <input type="text" name="ybmc" id="dialog_ybmc" value="${admissRec.ybmc}" size="16" readonly>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="bqdm" value="${admissRec.bqdm}">
                        <label for="dialog_bqmc" class="control-label x80">入院病区：</label>
                        <input type="text" name="bqmc" id="dialog_bqmc" value="${admissRec.bqmc}" size="16" readonly>
                    </td>
                    <td>
                        <input type="hidden" name="ksdm" value="${admissRec.ksdm}">
                        <label for="dialog_ksmc" class="control-label x80">入院科室：</label>
                        <input type="text" name="ksmc" id="dialog_ksmc" value="${admissRec.ksmc}" size="16" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dialog_djrq" class="control-label x80">登记日期：</label>
                        <input type="text" name="djrq" id="dialog_djrq" value="<fmt:formatDate value='${admissRec.djrq}' pattern='yyyy-MM-dd'/>" size="16" readonly>
                    </td>
                    <td>
                        <label for="dialog_ryrq" class="control-label x80">入院日期：</label>
                        <input type="text" name="ryrq" id="dialog_ryrq" value="<fmt:formatDate value='${admissRec.ryrq}' pattern='yyyy-MM-dd'/>" size="16" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dialog_rqrq" class="control-label x80">入区日期：</label>
                        <input type="text" name="rqrq" id="dialog_rqrq" value="<fmt:formatDate value='${admissRec.rqrq}' pattern='yyyy-MM-dd'/>" size="16" readonly>
                    </td>
                    <td>
                        <label for="dialog_cqrq" class="control-label x80">出区日期：</label>
                        <input type="text" name="cqrq" id="dialog_cqrq" value="<fmt:formatDate value='${admissRec.cqrq}' pattern='yyyy-MM-dd'/>" size="16" readonly>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="dialog_cyrq" class="control-label x80">出院日期：</label>
                        <input type="text" name="cyrq" id="dialog_cyrq" value="<fmt:formatDate value='${admissRec.cyrq}' pattern='yyyy-MM-dd'/>" size="16" readonly>
                    </td>
                    <td>
                        <label for="dialog_jsrq" class="control-label x80">结算日期：</label>
                        <input type="text" name="jsrq" id="dialog_jsrq" value="<fmt:formatDate value='${admissRec.jsrq}' pattern='yyyy-MM-dd'/>" size="16" readonly>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2" align="left"><h4>来源信息</h4></td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="docId">
                        <label for="dialog_docName" class="control-label x80">介绍医生：</label>
                        <input type="text" name="docName" id="dialog_docName" data-rule="required" size="16"
                            data-toggle="lookup" data-url="<%=request.getContextPath()%>/market/hzys/coworkDocAction!selectDoc.action"
                            data-group="" data-width="700">
                    </td>
                    <td>
                        <input type="hidden" name="userId">
                        <label for="dialog_docName" class="control-label x80">市场部人员：</label>
                        <input type="text" name="userName" id="dialog_docName" data-rule="required" size="16"
                            data-toggle="lookup" data-url="<%=request.getContextPath()%>/market/group/groupAction!selectMem.action"
                            data-group="" data-width="700">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="left">
                    	<label for="dialog_memo" class="control-label x80">备注：</label>
                    	<input type="text" name="memo"  id="dialog_memo" size="49">
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