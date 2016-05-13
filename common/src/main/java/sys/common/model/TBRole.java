package sys.common.model;

import java.util.Set;

public class TBRole {
	private String id;
	private String code;
	private String name;
	private boolean enable;
	private Set<TBMenu> menus;

	public TBRole() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<TBMenu> getMenus() {
		return menus;
	}

	public void setMenus(Set<TBMenu> menus) {
		this.menus = menus;
	}
}
