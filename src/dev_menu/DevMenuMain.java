package dev_menu;

import main.StarbuckMain;
import menu_ma.MenuMaMain;

import java.sql.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DB.DBUtil;
import cus_ma.CusMa;

public class DevMenuMain {
	Scanner sc = new Scanner(System.in);

	public DevMenuMain(List<CusMa> user) {
		StarbuckMain.printBoxTop("create menu");
		System.out.print("메뉴이름:");
		String name = sc.nextLine();
		System.out.print("\n메뉴 개발 날짜");
		System.out.println(name);
		StarbuckMain.printBoxEnd();
	}

	public DevMenuMain(List<CusMa> user, String title, int code) {
		StarbuckMain.printBoxTop(title);
		if (code == 1) {
			List<DevMenu> devmenu = new ArrayList<DevMenu>();
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();

				PreparedStatement pstat = null;
				String menuNm = "";
				String menuIntro = "";
				int menuPri = 0;

				System.out.println("생성할 메뉴의 이름을 입력해 주세요");
				menuNm = sc.nextLine();

				System.out.println("생성할 메뉴의 설명을 입력해 주세요");
				menuIntro = sc.nextLine();

				System.out.println("생성할 메뉴의 가격을 입력해 주세요");
				menuPri = sc.nextInt();
				String sql = "INSERT INTO MENU_MA(MENU_NO, MENU_NM, MENU_INTRO, MENU_PRI, DEL_YN) VALUES (MENU_MA_SEQ.NEXTVAL, \'"
						+ menuNm + "\', \'" + menuIntro + "\', " + menuPri + ", DEFAULT)";

				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
				System.out.println("데이터가 생성되었습니다.");
				util.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sc.close();
			StarbuckMain.printBoxEnd();
			MenuMaMain m = new MenuMaMain(user);
		} else if (code == 2) {
			List<DevMenu> devMenu = new ArrayList<DevMenu>();
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();

				PreparedStatement pstat = null;
				String sql = "SELECT * FROM DEV_MENU ORDER BY MENU_NO";

				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
				while (rs.next()) {
					DevMenu menu = new DevMenu(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4),
							rs.getString(5));
					devMenu.add(menu);
				}
				util.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (DevMenu devMenu2 : devMenu) {
				System.out.println(devMenu.toString());
			}
			sc.close();
			StarbuckMain.printBoxEnd();
			MenuMaMain m = new MenuMaMain(user);
		} else if (code == 3) {
			List<DevMenu> devMenu = new ArrayList<DevMenu>();
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();
				
				String type = "";
				String val = "";
				int menuNo = 0;

				System.out.println("수정할 칼럼의 이름을 입력해주세요");
				type = sc.nextLine();
				System.out.println("수정되어 들어갈 내용을 입력해주세요");
				val = sc.nextLine();
				System.out.println("수정될 레코드의 메뉴넘버를 입력해주세요");
				menuNo = sc.nextInt();
				
				PreparedStatement pstat = null;
				String sql = "UPDATE MENU_MA SET " + type + " = \'" + val + "\'" + " WHERE MENU_NO = " + menuNo;				
				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
				util.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sc.close();
			StarbuckMain.printBoxEnd();
			MenuMaMain m = new MenuMaMain(user);
		} else if (code == 4) {
			
			List<DevMenu> devmenu = new ArrayList<DevMenu>();
			try {
				DBUtil util = new DBUtil();
				Connection conn = null;
				conn = util.open();
				
				int menuNo = 0;
				System.out.println("삭제할 레코드의 메뉴넘버를 입력해주세요");
				menuNo = sc.nextInt();
				
				PreparedStatement pstat = null;
				String sql = "DELETE FROM MENU_MA WHERE MENU_NO = "+menuNo;
				pstat = conn.prepareStatement(sql);
				ResultSet rs = null;
				rs = pstat.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sc.close();
			StarbuckMain.printBoxEnd();
			MenuMaMain m = new MenuMaMain(user);
		} else {
			System.out.println("위의 번호만 입력해주세요");
			MenuMaMain m = new MenuMaMain(user);
		}

	}
}
