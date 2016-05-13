package sys.evalsetting.action;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;

import sys.Eval.page.Model.BiCorporation;

import com.alibaba.fastjson.JSON;

@ParentPackage("default")
public class BaseAction {
	private static final Logger logger = Logger.getLogger(BiCorporation.class);
	public void writeJson(Object object) {
		try {
			logger.info("开始转换返回结果");
			String json = JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
			logger.info("返回结果:"+json);
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setAttribute(String attributeName ,Object attributeValue) {
		ServletActionContext.getRequest().setAttribute(attributeName, attributeValue);
	}
}
