package DummyData;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import DB.DBUtil;

public class MakeDummy {
	private static Connection conn = null;				// DB 연결 정보를 가지고있는 객체 
	private static Statement stat = null;				// 연결정보를 가지고 SQL문을 실행하는 객체
	private static PreparedStatement pstat = null;		// 연결정보를 가지고 SQL문을 실행하는 객체 (파라미터 매핑, 캐시 사용)
	private static CallableStatement cstat = null;		// 연결정보를 가지고 SQL문을 실행하는 객체 (프로시저 전용)
	private static ResultSet rs = null;					// 결과값을 담고있는 객체
	private static DBUtil util = new DBUtil();
	private static Random rand = new Random();
	public static void main(String[] args) {
	}
	public static void menu_ma_dummy() {
		try {
			conn = util.open();
			String[] menuNmOne = {"아이스", "핫", "유기농", "화이트", "다크", "더블 샷", "클래식"};
			String[] menuNmTwo = {"초코", "바닐라", "자바 칩", "돌체", "딸기", "카라멜", "슈크림", "돌체", "카페", "헤이즐넛", "크림", "흑설탕"};
			String[] menuNmThr = {"아메리카노", "에스프레소", "프라푸치노", "티", "라떼", "콜드 브루", "마키아또", "카푸치노", "아포가토", "블렌디드", "에이드", "주스", "모카"};
			for (int i = 0; i < 30; i++) {
				
				String menuNmOne_save = menuNmOne[rand.nextInt(menuNmOne.length)];
				String menuNmTwo_save = menuNmTwo[rand.nextInt(menuNmTwo.length)];
				String menuNmThr_save = menuNmThr[rand.nextInt(menuNmThr.length)];
			
				String menuNm = menuNmOne_save + " " + menuNmTwo_save + " " + menuNmThr_save;
				String menuDesc = menuNmTwo_save + "(이)가 들어간 " + menuNmOne_save + " "+ menuNmThr_save + " 입니다.";
				
				String sql = "INSERT INTO MENU_MA(MENU_NO, MENU_NM, MENU_INTRO, MENU_PRI, DEL_YN) VALUES (MENU_MA_SEQ.NEXTVAL, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, menuNm);
				pstat.setString(2, menuDesc);
				pstat.setInt(3, (rand.nextInt(80-34)+35)*100);
				pstat.execute();
				pstat.close();
			}
			conn.close();
			System.out.println("menuNm inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void stat() {
		
		try {
			conn = util.open();
			int rec_no = 1234;
//			String sql = "INSERT INTO PROF_MA(CAL_DATE, PROFIT, EXPENCES, DEL_YN) VALUES (" + cal_date + " , " + profit + ", " + expences + ", '" + del_yn + "')";
//			System.out.println(sql);
			String sql = "SELECT * FROM PROF_MA";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			
			while(rs.next()) {
				System.out.print(rs.getString("CAL_DATE"));
				System.out.print("   -  ");
				int test = rs.getInt("PROFIT");
				System.out.printf("%,d", test*10000);
				System.out.print("   -  ");
				System.out.print(rs.getString("EXPENCES"));
				System.out.println();
			}
			System.out.println("DB인설트 완료");
			stat.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void pstat() {
		try {
			conn = util.open();
			String sql = "INSERT INTO PROF_MA(CAL_DATE, PROFIT, EXPENCES, DEL_YN) VALUES (SYSDATE, ?, ?, ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, 500);
			pstat.setInt(2, 700);
			pstat.setString(3, "N");
			pstat.executeQuery();
			
			sql = "SELECT * FROM PROF_MA";
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("CAL_DATE"));
				System.out.print("   -  ");
				int test = rs.getInt("PROFIT");
				System.out.printf("%,d", test*10000);
				System.out.print("   -  ");
				System.out.print(rs.getString("EXPENCES"));
				System.out.println();
			}
			pstat.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cstat() {
		try {
			conn = util.open();
			String sql = "{call TEST_01(SYSDATE, ?, ?, ?) }";
			cstat = conn.prepareCall(sql);
			cstat.setInt(1, 1000);
			cstat.setInt(2, 200);
			cstat.setString(3, "N");
			cstat.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
