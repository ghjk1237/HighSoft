package sys.common.page.model;

import org.springframework.stereotype.Repository;

@Repository("json")
public class Json implements java.io.Serializable {
	private boolean success = false;
	private String msg = "";
	private Object result = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
