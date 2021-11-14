package vo;

public class Todo {
	// 정보은닉
	private int todoNo;
	private String memberId; // Member테이블의 memberId 외래키이므로 private Member member; 가능하다
	private String todoDate;
	private String todoContent;
	private String createDate;
	private String updateDate;
	private String fontColor;
	
	// 캡슐화
	public int getTodoNo() {
		return todoNo;
	}
	public void setTodoNo(int todoNo) {
		this.todoNo = todoNo;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(String todoDate) {
		this.todoDate = todoDate;
	}
	
	public String getTodoContent() {
		return todoContent;
	}
	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	
	@Override
	public String toString() {
		return "Todo [todoNo=" + todoNo + ", memberId=" + memberId + ", todoDate=" + todoDate + ", todoContent="
				+ todoContent + ", createDate=" + createDate + ", updateDate=" + updateDate + ", fontColor=" + fontColor
				+ "]";
	}
}
