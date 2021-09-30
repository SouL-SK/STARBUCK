package main;

import java.util.Scanner;

public class StarbuckMain {

	public static void main(String[] args) {
		System.out.println("                                                                                \r\n"
				+ "                                                                                \r\n"
				+ "                                     iv5SPKS1v:.                                \r\n"
				+ "                                  SQQKvi:..:ivSgQD1.                            \r\n"
				+ "                                RBJ              .sQBP.                         \r\n"
				+ "                              vQr                    sBB.                       \r\n"
				+ "                             JBr                       YBs                      \r\n"
				+ "                            .ZBQEPgZBi                   QY                     \r\n"
				+ "                          iBBY.     QB                   :Q                     \r\n"
				+ "                         BBi  ..... .B..rs5Q:             Bi                    \r\n"
				+ "                  PQDgPBBX  ...:..  :BgLYY:SB.            B.                    \r\n"
				+ "                  BQ:.:Bs ....... :BBBB5    IB  :jEQBr   2B                     \r\n"
				+ "                   IBuQg ......:. ZBBBBBi .. PQgd1: BBB:.B.                     \r\n"
				+ "                     gB. ........ :BBBBE..... .   . 1B QBr                      \r\n"
				+ "                     7B ...:......  :r.  .......... LB                          \r\n"
				+ "                     DB ......:.:...   .....:...... DB                          \r\n"
				+ "                     gB .................:.:.:...:. vBi                         \r\n"
				+ "                     LB ..............:.....:...:... :RQZULi:..                 \r\n"
				+ "                      Br ..............:.:...:.:.:.... .:7sjjBg                 \r\n"
				+ "                      XQ  ......:.................:......   RB                  \r\n"
				+ "                       QB. ........:...:.....:........... .BB                   \r\n"
				+ "                        PBr  .........:...:............ .2B1                    \r\n"
				+ "                          BBv.   ...................  .uBg                      \r\n"
				+ "                     rr  7BuIQQSL:...           ..:7XgBd                        \r\n"
				+ "                     rgBBM    .75ZDRDDddqPqPqPbDgMZqr .Mu                      \r\n"
				+ "                                     ...::i::...       BB      **                 \r\n"
				+ "                                                      r7                        \r\n"
				+ "                                                                                \r\n"
				+ "                                                                                \r\n"
				+ "                                                                                ");
		printBoxTop("MAIN");

		System.out.println("메뉴를 선택해주세요.");
		System.out.println("1. 직원 로그인");
		System.out.println("2. 점장 로그인");
		printBoxEnd();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input.equals("1")) {
			EmployeeLoginMain s = new EmployeeLoginMain();
		} else if (input.equals("2")) {
			EmployerLoginMain s = new EmployerLoginMain();
		}
	}

	public static void printBoxTop(String text) {
		String[] tmp = text.split("");
		String txt = " ";
		for (String string : tmp) {
			txt += string;
			txt += " ";
		}
		System.out.print("┌");
		for (int i = 0; i < (50 - txt.length()) / 2; i++) {
			System.out.print("─");
		}
		System.out.print(txt);
		for (int i = (50 - txt.length()) / 2; i < 50 - txt.length(); i++) {
			System.out.print("─");
		}
		System.out.println("┐");
	}

	public static void printBoxEnd() {
		System.out.print("└");
		for (int i = 0; i < 50; i++) {
			System.out.print("─");
		}
		System.out.println("┘");
		System.out.println();
	}
}
