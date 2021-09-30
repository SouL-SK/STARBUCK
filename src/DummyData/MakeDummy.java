package DummyData;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import DB.DBUtil;

public class MakeDummy {
	private static Connection conn = null; // DB 연결 정보를 가지고있는 객체
	private static Statement stat = null; // 연결정보를 가지고 SQL문을 실행하는 객체
	private static PreparedStatement pstat = null; // 연결정보를 가지고 SQL문을 실행하는 객체 (파라미터 매핑, 캐시 사용)
	private static CallableStatement cstat = null; // 연결정보를 가지고 SQL문을 실행하는 객체 (프로시저 전용)
	private static ResultSet rs = null; // 결과값을 담고있는 객체
	private static DBUtil util = new DBUtil();
	private static Random rand = new Random();
	
	public static void main(String[] args) {
		
//		furn_ma_dummy();
//		sto_ma_dummy();
//		park_ma_dummy();
//		grade_dummy();
//		cus_ma_dummy();
//		prof_ma_dummy();
//		menu_ma_dummy();
//		emp_ma_dummy();
//		vac_ma_dummy();
//		tna_ma();
//		inte_ma_dummy();
//		salary_dummy();
//		cal_fee_dummy();
//		sell_menu_dummy();
		point_dummy();
//		ord_ma_dummy();
//		recipe_dummy();
//		dev_menu_dummy();
	}

	private static ArrayList<Object> insert(String cl, String tb, String type) {
		// 일대일 관계면 그냥 포문 돌리는게 빨라 이런데다 시간쓰기 아까워
		ArrayList<Object> result = new ArrayList<Object>();
		try {
			conn = util.open();
			String sql = "SELECT " + cl + " FROM " + tb;
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			switch (type) {
			case "int":
				while (rs.next()) {
					result.add(rs.getInt(cl));
				}
				break;
			case "String":
				while (rs.next()) { // rs.next << rs 하나가 커서 하나(한 줄) next 를 이용해서 다음줄로 넘어가면서 뽑아온다.
					result.add(rs.getString(cl));
				}
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private static void salary_dummy() {
		try {
			conn = util.open();
			Date date = new Date(0);
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("EMP_NO", "EMP_MA", "int");
			int empNo;
			for (int i = 0; i < 20; i++) {
				String d = MakeFuction.makeRanDatePa(30);
				date = java.sql.Date.valueOf(d);
				empNo = (int) list.get(rand.nextInt(list.size()));
				String sql = "INSERT INTO SALARY(SAL_NO, EMP_NO, SAL_DATE, SAL_AMT, DEL_YN) VALUES(SALARY_SEQ.NEXTVAL, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, empNo);
				pstat.setDate(2, date);
				pstat.setInt(3, MakeFuction.makeRanNo(350, 1000));
				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("SALARY INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void tna_ma() {
		try {
			conn = util.open();
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("EMP_NO", "EMP_MA", "int");
			for (int i = 0; i < 20; i++) {
				int empNo = (int) list.get(rand.nextInt(list.size()));
				String sql = "INSERT INTO TNA_MA(TNA_NO, ATT_DATE, COL_DATE, EMP_NO, DEL_YN) VALUES(TNA_MA_SEQ.NEXTVAL, SYSDATE, SYSDATE, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, empNo);
				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("TNA MA INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void vac_ma_dummy() {
		try {
			conn = util.open();
			Date date = new Date(0);
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("EMP_NO", "EMP_MA", "int");
			for (int i = 0; i < 20; i++) {
				String d = MakeFuction.makeRanDatePa(30);
				date = java.sql.Date.valueOf(d);
				int empNo = (int) list.get(rand.nextInt(list.size()));
				String sql = "INSERT INTO VAC_MA(VAC_NO, EMP_NO, VAC_TYPE, VAC_DATE, DEL_YN) VALUES(VAC_MA_SEQ.NEXTVAL, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, empNo);
				pstat.setString(2, MakeFuction.makeRanVacType());
				pstat.setDate(3, date);

				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("VAC MA INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void inte_ma_dummy() { // ORA-00984: 열을 사용할 수 없습니다 오류 -> BABO SOUL
		try {
			conn = util.open();
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("STO_NO", "STO_MA", "int");
			for (int i = 0; i < 20; i++) {
				int stoNo = (int) list.get(rand.nextInt(list.size()));
				String sql = "INSERT INTO INTE_MA(INTE_NO, INTE_NM, INTE_TYPE, INTE_LOC, STO_NO, DEL_YN) VALUES(INTE_MA_SEQ.NEXTVAL, ?, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, MakeFuction.makeRanNm());
				pstat.setString(2, MakeFuction.makeRanInteType());
				pstat.setString(3, MakeFuction.makeRanLoc());
				pstat.setInt(4, stoNo);
				pstat.execute();
				pstat.close();

			}
			conn.close();
			System.out.println("INTE MA INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void point_dummy() {
		try {
			conn = util.open();
			Date date = new Date(0);
			ArrayList<Object> list = new ArrayList<Object>();
			ArrayList<Object> list1 = new ArrayList<Object>();
			list = insert("CUS_NO", "CUS_MA", "int");
			list1 = insert("EMP_NO", "EMP_MA", "int");
			for (int i = 0; i < 20; i++) {
				String d = MakeFuction.makeRanDatePa(1000);
				date = java.sql.Date.valueOf(d);
				int cusNo = (int) list.get(rand.nextInt(list.size()));
				int empNo = (int) list1.get(rand.nextInt(list1.size()));
				String sql = "INSERT INTO POINT(POINT_NO, CUS_NO, ACC_POINT, ACC_DATE, EMP_NO, DEL_YN) VALUES(POINT_SEQ.NEXTVAL, ?, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, cusNo);
				pstat.setInt(2, MakeFuction.makeRanNo(0, 500));
				pstat.setDate(3, date);
				pstat.setInt(4, empNo);
				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("POINT INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void emp_ma_dummy() {
		try {
			conn = util.open();
			Date date = new Date(0);
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("STO_NO", "STO_MA", "int");
			int stoNo;
			for (int i = 0; i < 20; i++) {
				String d = MakeFuction.makeRanDatePa(1000);
				date = java.sql.Date.valueOf(d);
				stoNo = (int) list.get(rand.nextInt(list.size()));
				String sql = "INSERT INTO EMP_MA(EMP_NO, EMP_NM, EMP_GRD, HIRE_DATE, FIRE_DATE, STO_NO, DEL_YN) VALUES(EMP_MA_SEQ.NEXTVAL, ?, ?, ?, null, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, MakeFuction.makeRanNm());
				pstat.setString(2, MakeFuction.makeRanEmpGrd());
				pstat.setDate(3, date);
				pstat.setInt(4, stoNo);
				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("EMP MA INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void ord_ma_dummy() {
		try {
			conn = util.open();
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("FURN_NO", "FURN_MA", "int");
			ArrayList<Object> list1 = new ArrayList<Object>();
			list1 = insert("STO_NO", "STO_MA", "int");
			for (int i = 0; i < 20; i++) {
				int furnNo = (int) list.get(rand.nextInt(list.size()));
				int stoNo = (int) list1.get(rand.nextInt(list1.size()));
				String sql = "INSERT INTO ORD_MA(ORD_NO, FURN_NO, STO_NO, ORD_AMT, DIS_AMT, ORD_PRI, DEL_YN) VALUES(ORD_MA_SEQ.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, furnNo);
				pstat.setInt(2, stoNo);
				pstat.setInt(3, MakeFuction.makeRanNo(0, 100));
				pstat.setInt(4, MakeFuction.makeRanNo(0, 10));
				pstat.setInt(5, MakeFuction.makeRanNo(0, 1000000));
				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("ORD MA INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void cal_fee_dummy() {
		try {
			conn = util.open();
			ArrayList<Object> list = new ArrayList<Object>();
			ArrayList<Object> list1 = new ArrayList<Object>();
			list = insert("CUS_NO", "CUS_MA", "int");
			list1 = insert("PARK_NO", "PARK_MA", "int");
			for (int i = 0; i < 20; i++) {
				int cusNo = (int) list.get(rand.nextInt(list.size()));
				int parkNo = (int) list1.get(rand.nextInt(list1.size()));
				String sql = "INSERT INTO CAL_FEE(CAL_NO, CUS_NO, PARK_NO, FEE, DEL_YN) VALUES(CAL_FEE_SEQ.NEXTVAL, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, cusNo);
				pstat.setInt(2, parkNo);
				pstat.setInt(3, MakeFuction.makeRanNo(0, 100000000));
				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("CAL FEE INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void sell_menu_dummy() {
		try {
			conn = util.open();
			ArrayList<Object> list = new ArrayList<Object>();
			ArrayList<Object> list1 = new ArrayList<Object>();
			ArrayList<Object> list2 = new ArrayList<Object>();
			list = insert("MENU_NO", "MENU_MA", "int");
			list1 = insert("CUS_NO", "CUS_MA", "int");
			list2 = insert("EMP_NO", "EMP_MA", "int");

			for (int i = 0; i < 20; i++) {
				ArrayList<Integer> menuList = new ArrayList<Integer>();
				int cusNo = (int) list1.get(rand.nextInt(list1.size()));
				int empNo = (int) list2.get(rand.nextInt(list2.size()));

				for (int j = 0; j < rand.nextInt(4) + 1; j++) {
					menuList.add((Integer) list.get(rand.nextInt(list.size())));
				}
				String sql = "INSERT INTO SELL_MENU(SELL_NO, SELL_DATE, DIS_YN, MENU_NO, CUS_NO, EMP_NO, DEL_YN, BILL_NO) VALUES(SELL_MENU_SEQ.NEXTVAL, SYSDATE, DEFAULT, ?, ?, ?, DEFAULT, BILL_NO_SEQ.NEXTVAL)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, menuList.get(0));
				pstat.setInt(2, cusNo);
				pstat.setInt(3, empNo);
				pstat.execute();
				pstat.close();
				if (menuList.size() != 1) {
					for (int j = 1; j < menuList.size(); j++) {
						sql = "INSERT INTO SELL_MENU(SELL_NO, SELL_DATE, DIS_YN, MENU_NO, CUS_NO, EMP_NO, DEL_YN, BILL_NO) VALUES(SELL_MENU_SEQ.NEXTVAL, SYSDATE, DEFAULT, ?, ?, ?, DEFAULT, BILL_NO_SEQ.CURRVAL)";
						pstat = conn.prepareStatement(sql);
						pstat.setInt(1, menuList.get(j));
						pstat.setInt(2, cusNo);
						pstat.setInt(3, empNo);
						pstat.execute();
						pstat.close();
					}
				}
			}
			conn.close();
			System.out.println("SELL MENU INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void recipe_dummy() {
		try {
			conn = util.open();
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("MENU_NO", "MENU_MA", "int");
			ArrayList<Object> list1 = new ArrayList<Object>();
			list1 = insert("FURN_NO", "FURN_MA", "int");
			for (int i = 0; i < 20; i++) {
				int menuNo = (int) list.get(rand.nextInt(list.size()));
				int furnNo = (int) list1.get(rand.nextInt(list1.size()));
				String sql = "INSERT INTO RECIPE(REC_NO, MENU_NO, FURN_NO, REC_ING, DEL_YN) VALUES(RECIPE_SEQ.NEXTVAL, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, menuNo);
				pstat.setInt(2, furnNo);
				pstat.setString(3, MakeFuction.makeRanIng());
				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("RECIPE INSERTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void dev_menu_dummy() {
		try {
			conn = util.open();
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("MENU_NO", "MENU_MA", "int");
			ArrayList<Object> list1 = new ArrayList<Object>();
			list1 = insert("EMP_NO", "EMP_MA", "int");
			for (int i = 0; i < 20; i++) {
				int menuNo = (int) list.get(rand.nextInt(list.size()));
				int empNo = (int) list1.get(rand.nextInt(list1.size()));
				String sql = "INSERT INTO DEV_MENU(MENU_NO, TEST_COUNT, EMP_NO, DEV_DATE, DEL_YN) VALUES(?, ?, ?, SYSDATE, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, menuNo);
				pstat.setInt(2, MakeFuction.makeRanNo(0, 10));
				pstat.setInt(3, empNo);
				pstat.execute();
				pstat.close();

			}

			conn.close();
			System.out.println("DEV_MENU INSETED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void prof_ma_dummy() {
		try {
			conn = util.open();

			int prof;
			int expe;
			prof = MakeFuction.makeRanNo(0, 100000000);
			expe = MakeFuction.makeRanNo(0, 100000000);
			String sql = "INSERT INTO PROF_MA(CAL_DATE, PROFIT, EXPENCES, DEL_YN) VALUES(SYSDATE, ?, ?, DEFAULT)";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, prof);
			pstat.setInt(2, expe);
			pstat.execute();
			pstat.close();
			conn.close();
			System.out.println("inseted data to prof_ma_dummy");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void cus_ma_dummy() {
		Scanner sc = new Scanner(System.in);
		try {
			conn = util.open();
			Date date = new Date(0);
			ArrayList<Object> list = new ArrayList<Object>();
			list = insert("GRD_NO", "GRADE", "int");
			for (int i = 0; i < 2; i++) {
				String cusNm = MakeFuction.makeRanNm();
				String phone = MakeFuction.makeRanPhone();
				String d = MakeFuction.makeRanDatePa(365);
				date = java.sql.Date.valueOf(d);
				String carNum = MakeFuction.makeRanCarNum();
				int grdNo = (int) list.get(rand.nextInt(list.size()));
				System.out.println("사용하실 아이디를 입력해주세요");
				String id = sc.next();
				System.out.println("사용하실 비밀번호를 입력하세요.");
				String pass = sc.next();
				System.out.println("다시 한번 비밀번호를 입력해주세요");
				String passCheck = sc.next();
				if (pass.equals(passCheck)) {
					String sql = "INSERT INTO CUS_MA(CUS_NO, CUS_NM, CUS_ID, CUS_PASS, PHONE, LAST_VISIT, CAR_NUM_1, CAR_NUM_2, GRD_NO, APP_DATE, DEL_YN) VALUES(CUS_MA_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, NULL, ?, SYSDATE, DEFAULT)";
					pstat = conn.prepareStatement(sql);
					pstat.setString(1, cusNm);
					pstat.setString(2, id);
					pstat.setString(3, pass);
					pstat.setString(4, phone);
					pstat.setDate(5, date);
					pstat.setString(6, carNum);
					pstat.setInt(7, grdNo);
					pstat.execute();
					pstat.close();
				}else {
					System.out.println("처음부터 다시 시도해 주세요");
					cus_ma_dummy();
				}
			}
			conn.close();
			sc.close();
			System.out.println("inserted data in cus_ma");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void park_ma_dummy() {
		try {
			conn = util.open();

			Date exDate = new Date(0);
			for (int i = 0; i < 20; i++) {
				String carNo = MakeFuction.makeRanCarNum();
				String date = MakeFuction.makeRanDateFu(7);
				exDate = java.sql.Date.valueOf(date);
				String sql = "INSERT INTO PARK_MA(PARK_NO, CAR_NO, ENTRY_TM, EXIT_TM, DEL_YN) VALUES(PARK_MA_SEQ.NEXTVAL, ?, DEFAULT, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, carNo);
				pstat.setDate(2, exDate);
				pstat.execute();
				pstat.close();
			}
			conn.close();
			System.out.println("inserted data in park_ma");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void grade_dummy() {
		try {
			conn = util.open();

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

			for (int i = 0; i < 10; i++) {
				String stoNm = "스타벅스 " + MakeFuction.makeRanLoc();
				String sql = "INSERT INTO STO_MA(STO_NO, STO_NM, STO_LOC, STO_SEAT, STO_GRD, DEL_YN) VALUES(STO_MA_SEQ.NEXTVAL, ?, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, stoNm);
				pstat.setString(2, MakeFuction.makeRanLoc());
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

	public static void furn_ma_dummy() {
		try {
			conn = util.open();
			String typeOne = "식재료";
			String typeTwo = "소모품";

			String[] nmTwo = { "우유", "생크림", "딸기", "초코", "바닐라", "카라멜", "헤이즐넛", "설탕", "흑설탕", "얼음", "예가체프", "산토스", "수프리모",
					"AA 원두", "자바" };
			String[] nmThr = { "휴지", "물티슈", "수저", "빨대", "시럽", "컵홀더" };

			String[] homeOne = { "케냐", "콜롬비아", "에티오피아", "탄자니아", "브라질", "파나마", "인도네시아", "과테말라" };
			String[] homeTwo = { "중국", "국산", "베트남" };

			String furnType = "";
			String furnNm = "";
			String furnHome = "";
			Date exDate = new Date(0);
			Date opDate = new Date(0);
			for (int i = 0; i < 20; i++) {
				furnType = (i / 2 == 0) ? "식재료" : "소모품";
				switch (furnType) {
				case "식재료":
					furnNm = nmTwo[rand.nextInt(nmTwo.length)];
					furnHome = homeOne[rand.nextInt(homeOne.length)];
				case "소모품":
					furnNm = nmThr[rand.nextInt(nmThr.length)];
					furnHome = homeTwo[rand.nextInt(homeTwo.length)];

				}
				exDate = java.sql.Date.valueOf(MakeFuction.makeRanDateFu(31));
				opDate = java.sql.Date.valueOf(MakeFuction.makeRanDatePa(14));
				String sql = "INSERT INTO FURN_MA(FURN_NO, FURN_TYPE, FURN_NM, FURN_HOME, FURN_REM, EXPIR_DATE, OPEN_DATE, DEL_YN) VALUES(FURN_MA_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, furnType);
				pstat.setString(2, furnNm);
				pstat.setString(3, furnHome);
				pstat.setInt(4, rand.nextInt(10000));
				pstat.setDate(5, exDate);
				pstat.setDate(6, opDate);
				pstat.execute();
				pstat.close();
			}
			conn.close();
			System.out.println("inserted data in furn_ma");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void menu_ma_dummy() {
		try {
			conn = util.open();
			for (int i = 0; i < 30; i++) {
				String menuNm = MakeFuction.makeRanMenuNm("nm");
				String menuDesc = MakeFuction.makeRanMenuNm("desc");
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
