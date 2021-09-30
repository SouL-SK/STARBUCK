package sto_ma;

import java.util.List;

import cus_ma.CusMa;
import main.StarbuckMain;

public class StoMaMain {

	public StoMaMain(List<CusMa> user) {
		StarbuckMain.printBoxTop("Store manage");
		System.out.println("1. 발주 관리");
		System.out.println("2. 인테리어 관리");
		System.out.println("3. 비품 관리");
		System.out.println("4. ");
	}

}
