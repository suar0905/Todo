package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Notice;

public class NoticeDao {
	
	// (1) 최신 공지 5개 출력하는 메소드
	public List<Notice> selectNoticeList5(Connection conn) throws SQLException {
		// 쿼리 생성
		String sql = NoticeQuery.SELECT_NOTICE_LIST5;
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		
		// List 클래스 배열 객체 생성
		List<Notice> noticeList = new ArrayList<>();
		
		while(rs.next()) {
			// Notice 클래스 객체 생성
			Notice notice = new Notice();
			notice.setNoticeNo(rs.getInt("noticeNo"));
			notice.setNoticeTitle(rs.getString("noticeTitle"));
			notice.setNoticeContent(rs.getString("noticeContent"));
			notice.setCreateDate(rs.getString("createDate"));
			notice.setUpdateDate(rs.getString("updateDate"));
			
			noticeList.add(notice);
		}
		
		// 기록 종료
		rs.close();
		stmt.close();
		
		return noticeList;
	}
}
