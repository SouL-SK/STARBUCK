package DummyData;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
//import java.time.LocalDate;

import DB.DBUtil;

public class MakeDummy {
	private static Connection conn = null; // DB 연결 정보를 가지고있는 객체
	private static Statement stat = null; // 연결정보를 가지고 SQL문을 실행하는 객체
	private static PreparedStatement pstat = null; // 연결정보를 가지고 SQL문을 실행하는 객체 (파라미터 매핑, 캐시 사용)
	private static CallableStatement cstat = null; // 연결정보를 가지고 SQL문을 실행하는 객체 (프로시저 전용)
	private static ResultSet rs = null; // 결과값을 담고있는 객체
	private static DBUtil util = new DBUtil();
	private static Random rand = new Random();

//	private static LocalDate randDate = createRandomDate(2021, 2022);
	public static void main(String[] args) {

	}
	
	public static void park_ma_dummy() {
		try {
			conn = util.open();

			String[] carNoTwo = { "가", "나", "다", "라", "마", "바", "공", "해", "육", "합", "국", "허", "하", "호", "배" };
			for (int i = 0; i < 20; i++) {
				int carOne = (rand.nextInt(99) + 1);
				int carThr = (rand.nextInt(9999) + 1);
				String carNoOne = String.format("%02d", carOne);
				String carNoThr = String.format("%04d", carThr);
				String carNo = carNoOne + carNoTwo[rand.nextInt(carNoTwo.length)] + " " + carNoThr;
				System.out.println(carNo);
				String sql = "INSERT INTO PARK_MA(PARK_NO, CAR_NO, ENTRY_TM, EXIT_TM, DEL_YN) VALUES(PARK_MA_SEQ.NEXTVAL, ?, DEFAULT, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, carNo);
//				pstat.setDate(2, exit_date);
				pstat.execute();
				pstat.close();
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void grade_dummy() {
		try {
			conn = util.open();

			int i = 0;
			String[] nmOne = { "브론즈", "실버", "골드", "다이아", "플래티넘" };
			String[] beneOne = { "캐시백 1%, 포인트 적립 1%", "캐시백 3%, 포인트 적립 3%", "캐시백 8%, 포인트 적립 8%, vip 혜택 적용",
					"캐시백 15%, 포인트 적립 15%, vip 혜택 적용", "캐시백 20%, 포인트 적립 20%, vip 혜택 적용, 라운지 이용 가능, 명절(설, 추석) 선물세트 증정" };
			for (int j = 0; j < 5; j++) {

				String grdNm = nmOne[j];
				String grdBene = "";

				switch (grdNm) {
				case "브론즈":
					grdBene = beneOne[0];
					break;
				case "실버":
					grdBene = beneOne[1];
					break;
				case "골드":
					grdBene = beneOne[2];
					break;
				case "다이아":
					grdBene = beneOne[3];
					break;
				case "플래티넘":
					grdBene = beneOne[4];
					break;
				default:
					break;
				}

				String sql = "INSERT INTO GRADE(GRD_NO, GRD_NM, GRD_BENE, DEL_YN) VALUES(GRADE_SEQ.NEXTVAL, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, grdNm);
				pstat.setString(2, grdBene);
				pstat.execute();
				pstat.close();
			}
			conn.close();
			System.out.println("grade_dummy inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sto_ma_dummy() {
		try {
			conn = util.open();

			String[] nmOne = { "도농점", "왕십리점", "청량리점", "회기점", "동대문점", "상봉점", "덕소점", "구리점" };
			String[] locOne = { "도농동", "구리시", "왕십리", "청량리", "회기동", "동대문구", "중랑구", "가운동" };
			for (int i = 0; i < 10; i++) {

				String stoNm = "스타벅스 " + nmOne[rand.nextInt(nmOne.length)];
				String stoLoc = locOne[rand.nextInt(locOne.length)];
				String sql = "INSERT INTO STO_MA(STO_NO, STO_NM, STO_LOC, STO_SEAT, STO_GRD, DEL_YN) VALUES(STO_MA_SEQ.NEXTVAL, ?, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, stoNm);
				pstat.setString(2, stoLoc);
				pstat.setInt(3, rand.nextInt(100));
				pstat.setInt(4, rand.nextInt(10) + 1);
				pstat.execute();
				pstat.close();
			}
			conn.close();
			System.out.println("sto_ma inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	이거 나중에 해야함
	public static void furn_ma_dummy() {
		try {
			conn = util.open();
			String typeOne = "식재료";
			String typeTwo = "소모품";

			
			String[] nmOne = { "예가체프", "산토스", "수프리모", "AA 원두", "자바" };
			String[] nmTwo = { "우유", "생크림", "딸기", "초코", "바닐라", "카라멜", "헤이즐넛", "설탕", "흑설탕", "얼음" };
			String[] nmThr = { "휴지", "물티슈", "수저", "빨대", "시럽", "컵홀더" };

			String[] homeOne = { "케냐", "콜롬비아", "에티오피아", "탄자니아", "브라질", "파나마", "인도네시아", "과테말라" };
			String[] homeTwo = { "중국", "국산", "베트남" };
			
			String furnType = "";
			String furnNm = "";
			String furnHome = "";
			switch (typeOne) {
			case "식재료":
				furnNm = nmOne[rand.nextInt(nmOne.length)] || nmTwo[rand.nextInt(nmTwo.length)];
				furnHome = homeOne[rand.nextInt(homeOne.length)];
				break;
			case "소모품":
				furnNm = nmThr[rand.nextInt(nmThr.length)];
				furnHome = homeTwo[rand.nextInt(homeTwo.length)];
			default:
				break;
			}
			String sql = "INSERT INTO FURN_MA(FURN_NO, FURN_TYPE, FURN_NM, FURN_HOME, FURN_REM, EXPIR_DATE, OPEN_DATE, DEL_YN) VALUES(FURN_MA_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT)";
			pstat = conn.prepareStatement(sql);

//			pstat.setDate(4, randDate);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static int createRandomIntBetween(int start, int end) {
//        return start + (int) Math.round(Math.random() * (end - start));
//    }
//	public static LocalDate createRandomDate(int startYear, int endYear) {
//		int day = createRandomIntBetween(1, 28);
//        int month = createRandomIntBetween(1, 12);
//        int year = createRandomIntBetween(startYear, endYear);
//        return LocalDate.of(year, month, day);
//	}
	public static void menu_ma_dummy() {
		try {
			conn = util.open();
			String[] menuNmOne = { "아이스", "핫", "유기농", "화이트", "다크", "더블 샷", "클래식" };
			String[] menuNmTwo = { "초코", "바닐라", "자바 칩", "돌체", "딸기", "카라멜", "슈크림", "돌체", "카페", "헤이즐넛", "크림", "흑설탕" };
			String[] menuNmThr = { "아메리카노", "에스프레소", "프라푸치노", "티", "라떼", "콜드 브루", "마키아또", "카푸치노", "아포가토", "블렌디드", "에이드",
					"주스", "모카" };
			for (int i = 0; i < 30; i++) {
				String menuNmOne_save = menuNmOne[rand.nextInt(menuNmOne.length)];
				String menuNmTwo_save = menuNmTwo[rand.nextInt(menuNmTwo.length)];
				String menuNmThr_save = menuNmThr[rand.nextInt(menuNmThr.length)];

				String menuNm = menuNmOne_save + " " + menuNmTwo_save + " " + menuNmThr_save;
				String menuDesc = menuNmTwo_save + "(이)가 들어간 " + menuNmOne_save + " " + menuNmThr_save + " 입니다.";

				String sql = "INSERT INTO MENU_MA(MENU_NO, MENU_NM, MENU_INTRO, MENU_PRI, DEL_YN) VALUES (MENU_MA_SEQ.NEXTVAL, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, menuNm);
				pstat.setString(2, menuDesc);
				pstat.setInt(3, (rand.nextInt(80 - 34) + 35) * 100);
				pstat.execute();
				pstat.close();
			}
			conn.close();
			System.out.println("menuNm inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
