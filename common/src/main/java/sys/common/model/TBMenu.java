package sys.common.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TBMenu entity. @author MyEclipse Persistence Tools
 */

public class TBMenu implements java.io.Serializable {

	// Fields

	private String id;
	private TBMenu TBMenu;
	private String url;
	private String txt;
	private Set TBMenus = new HashSet(0);

	// Constructors

	/** default constructor */
	public TBMenu() {
	}

	/** minimal constructor */
	public TBMenu(String id, String url, String txt) {
		this.id = id;
		this.url = url;
		this.txt = txt;
	}

	/** full constructor */
	public TBMenu(String id, TBMenu TBMenu, String url, String txt, Set TBMenus) {
		this.id = id;
		this.TBMenu = TBMenu;
		this.url = url;
		this.txt = txt;
		this.TBMenus = TBMenus;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TBMenu getTBMenu() {
		return this.TBMenu;
	}

	public void setTBMenu(TBMenu TBMenu) {
		this.TBMenu = TBMenu;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTxt() {
		return this.txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Set getTBMenus() {
		return this.TBMenus;
	}

	public void setTBMenus(Set TBMenus) {
		this.TBMenus = TBMenus;
	}
}