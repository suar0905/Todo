package service;

import java.sql.Connection;
import java.util.List;

import commons.DBUtil;
import dao.NoticeDao;
import vo.Notice;

public class NoticeService {
	private NoticeDao noticeDao;
	
	// (1) 최신 공지 5개 출력하는 메소드
	public List<Notice> getNoticeList5() {
		List<Notice> noticeList = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3306/todo", "root", "java1004");
			// noticeDao 클래스 객체 생성
			noticeDao = new NoticeDao();
			noticeList = noticeDao.selectNoticeList5(conn);
			System.out.println("[debug] TodoService : noticeList 확인 -> " + noticeList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return noticeList;
	}
}
