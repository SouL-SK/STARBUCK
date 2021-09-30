package cus_ma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DB.DBUtil;
import main.EmployerLoginMain;
import main.StarbuckMain;
import point.Point;

public class CusMaMain {

	public CusMaMain(List<CusMa> user) {
		Scanner sc = new Scanner(System.in);
		StarbuckMain.printBoxTop("Customer manage");
		System.out.println("1. 신규 회원 가입");
		System.out.println("2. 회원 조회");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 탈퇴");
		System.out.println("5. 이전 페이지로 돌아가기");
		System.out.println("0. 프로그램 종료");
		int key = sc.nextInt();
		while (key != 0) {
			switch (key) {
			case 1:
				CusMaMain c = new CusMaMain(user, "create customer", 1);
				break;
			case 2:
				CusMaMain r = new CusMaMain(user, "read customer", 2);
				break;
			case 3:
				CusMaMain u = new CusMaMain(user, "update customer", 3);
				break;
			case 4:
				CusMaMain d = new CusMaMain(user, "delete customer", 4);
				break;
			case 5:
				EmployerLoginMain b = new EmployerLoginMain(user);
			default:
				break;
			}
		}
	}
	
	public CusMaMain(List<CusMa> user, String title, int key) {
		if (key == 1) {
			StarbuckMain.printBoxTop(title);
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();
				PreparedStatement pstat = null;
				String sql = "";
				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
				util.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StarbuckMain.printBoxEnd();
			CusMaMain s = new CusMaMain(user);
		}else if (key == 2) {
			StarbuckMain.printBoxTop(title);
			List<Point> list = new ArrayList<Point>();
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();
				
				PreparedStatement pstat = null;
				String sql = "SELECT C.*, P.ACC_POINT, P.ACC_DATE, P.EMP_NO FROM CUS_MA C, POINT P WHERE C.CUS_NO = P.CUS_NO";
				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
				while (rs.next()) {
					CusMa cusList = new CusMa(rs.getInt("CUS_NO"), rs.getString("CUS_NM"), rs.getString("PHONE"), rs.getDate("LAST_VISIT"), rs.getString("CAR_NUM_1"), rs.getInt("GRD_NO"), rs.getDate("APP_DATE"), rs.getString("DEL_YN"));
					Point poList = new Point(cusList, rs.getInt("ACC_POINT"), rs.getDate("ACC_DATE"), rs.getInt("EMP_NO"));
					
//					CusMa cusList = new CusMa();
//					cusList.setCusNo(rs.getInt("CUS_NO"));
//					cusList.setCusNm(rs.getString("CUS_NM"));
//					cusList.setCusId(rs.getString("CUS_ID"));
//					cusList.setCusPass(rs.getString("CUS_PASS"));
					
//					CusMa cusList = new CusMa(rs.getInt("CUS_NO"), rs.getString("CUS_NM"), rs.getString("CUS_ID"), rs.getString("CUS_PASS"));
//					Point poList = new Point(cusList, rs.getInt("ACC__POINT"), rs.getDate("ACC_DATE"), rs.getInt("EMP_NO"));
					
					list.add(poList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
				System.out.println("-------------------------------------");
			}
			for (Point point : list) {
				System.out.println(list);
				System.out.println("-------------------------------------");
			}
			for (Point point : list) {
				System.out.println(list.toString());
				System.out.println("-------------------------------------");
			}
			StarbuckMain.printBoxEnd();
			CusMaMain b = new CusMaMain(user);
		}
	}
}
