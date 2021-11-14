package dao;

public class NoticeQuery {
	public static final String SELECT_NOTICE_LIST5; // 최신 공지 5개 출력
	
	static {
		SELECT_NOTICE_LIST5 = "SELECT notice_no noticeNo, notice_title noticeTitle, notice_content noticeContent, create_date createDate, update_Date updateDate "
								+ "FROM notice ORDER BY create_date DESC LIMIT 0,5";
	}
}
