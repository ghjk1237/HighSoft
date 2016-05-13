package sys.common.page.model;

public class Menu {
	private String id;
	private String parentId;
	private String url;
	private String txt;
	private boolean checked;
	private String roleId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Menu) {
			Menu menu = (Menu) obj;            
            return (id.equals(menu.id));
        }
        return super.equals(obj);
	}
	@Override
	public int hashCode() {
        Menu menu = this;
        return id.hashCode();
    }
}
