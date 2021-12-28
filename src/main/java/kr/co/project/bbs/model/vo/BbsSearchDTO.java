package kr.co.project.bbs.model.vo;

public class BbsSearchDTO {
	private String condition;
	private String searchText;
	
	public BbsSearchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BbsSearchDTO(String condition, String searchText) {
		super();
		this.condition = condition;
		this.searchText = searchText;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getSearchText() {
		return searchText;
	}
	
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "BbsSearchDTO [condition=" + condition + ", searchText=" + searchText + "]";
	}

}
