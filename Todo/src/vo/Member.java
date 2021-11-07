package vo;

public class Member {
	// 정보은닉
	/* 정보은닉이란 다른 객체에게 자신의 정보를 숨기고 자신의 연산만을 통하여 접근을 허용하는 것이다. 
	   이를 통해서 외부 객체가 특정 객체의 데이터화 함수를 직접 접근하여 사용하거나 변경하지 못하므로 
	   유지 보수와 소프트웨어 확장시 오류를 최소화할 수 있다 .*/
	private String memberId;
	private String memberPw;
	private String createDate;
	private String updateDate;
	
	// 캡슐화
	/* 캡슐화란 데이터(속성)와 데이터를 처리하는 함수를 하나로 묶는 것이다.
	   다시 말해 객체 외부에서는 객체 내부 정보를 직접 접근하거나 조작할 수 없고, 외부에서 접근할 수 있도록 정의된 오퍼레이션을 통해서만 관련 데이터에 접근할 수 있다. (getter,setter)
	   캡슐화의 장점은 객체의 세부내용이 외부에 은폐(정보 은닉)되어, 변경이 발생할 때 오류발생이 적으며 재사용이 용이하다.*/	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
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
	
	// toString() 메소드 : 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
}
