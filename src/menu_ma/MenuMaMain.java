package menu_ma;

import java.util.List;
import java.util.Scanner;

import cus_ma.CusMa;
import dev_menu.DevMenuMain;
import main.StarbuckMain;

public class MenuMaMain {
	Scanner sc = new Scanner(System.in);
	public MenuMaMain(List<CusMa> user) {
		StarbuckMain.printBoxTop("manege menu");
		System.out.println("1. 메뉴 등록");
		System.out.println("2. 메뉴 조회");
		System.out.println("3. 메뉴 수정");
		System.out.println("4. 메뉴 삭제");
		StarbuckMain.printBoxEnd();
		String key = sc.nextLine();
		switch (key) {
		case "1":
			DevMenuMain c = new DevMenuMain(user, "create menu", 1);
			break;
		case "2":
			DevMenuMain r = new DevMenuMain(user, "read menu", 2);
			break;
		case "3":
			DevMenuMain u = new DevMenuMain(user, "update menu", 3);
			break;
		case "4":
			DevMenuMain d = new DevMenuMain(user, "delete menu", 4);
			break;
		default:
			System.out.println("위에 번호 4가지 중에 고르세요");
			MenuMaMain s = new MenuMaMain(user);
			break;
		}
		sc.close();
	}

}
