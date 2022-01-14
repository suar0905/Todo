package vo;

public class Todo {
	// 정보은닉
	private int todoNo;
	private String memberId; // Member테이블의 memberId 외래키이므로 private Member member; 가능하다
	private String todoDate;
	private String todoContent;
	private int todoScore; // 일정 중요도
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
	
	public int getTodoScore() {
		return todoScore;
	}
	public void setTodoScore(int todoScore) {
		this.todoScore = todoScore;
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
	
	// 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드이다
	@Override
	public String toString() {
		return "Todo [todoNo=" + todoNo + ", memberId=" + memberId + ", todoDate=" + todoDate + ", todoContent="
				+ todoContent + ", todoScore=" + todoScore + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", fontColor=" + fontColor + "]";
	}
}
