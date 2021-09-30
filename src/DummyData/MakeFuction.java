package DummyData;

import java.util.Calendar;
import java.util.Random;
public class MakeFuction {
	private static Random rand = new Random();
	
	/**
	 * 범위를 받아서 랜덤 숫자 출력
	 * @param 최소값
	 * @param 최대값
	 * @return 랜덤 숫자
	 */
	public static int makeRanNo(int min, int max) {
		int result;
		result = rand.nextInt(max - min + 1) + min;
		return result;
	}
	public static String makeRanVacType() {
		String[] str = {"병가", "포상휴가", "연차", "반차", "소원휴가"};
		return str[rand.nextInt(str.length)];
	}
	public static String makeRanInteType() {
		String[] inte = {"의자", "첵상", "티비", "파티션", "조명", "선반", "책정"};
		return inte[rand.nextInt(inte.length)];
	}
	public static String makeRanLoc() {
		String[] nmOne = { "도농점", "왕십리점", "청량리점", "회기점", "동대문점", "상봉점", "덕소점", "구리점" };
		String[] locOne = { "도농동", "구리시", "왕십리", "청량리", "회기동", "동대문구", "중랑구", "가운동" };
		
		String stoLoc = locOne[rand.nextInt(locOne.length)];
		return stoLoc;
	}
	public static String makeRanEmpGrd() {
		String[] grd = {"연구원", "주임", "선임", "책임", "수석"};
		String result = grd[rand.nextInt(grd.length)];
		return result;
	}
	public static String makeRanIng() {
		String[] menuNmTwo = { "초코", "바닐라", "자바 칩", "돌체", "딸기", "카라멜", "슈크림", "돌체", "카페", "헤이즐넛", "크림", "흑설탕" };
		String[] menuNmThr = { "아메리카노", "에스프레소", "프라푸치노", "티", "라떼", "콜드 브루", "마키아또", "카푸치노", "아포가토", "블렌디드", "에이드",
				"주스", "모카" };
		String str = "";
		for (int i = 0; i < rand.nextInt(10)+1; i++) {
			str += menuNmTwo[rand.nextInt(menuNmTwo.length)]+", ";
			str += menuNmThr[rand.nextInt(menuNmThr.length)]+", ";
		}
		str += "장인의 손맛";
		return str;
	}
	public static String makeRanMenuNm(String str) {
		String[] menuNmOne = { "아이스", "핫", "유기농", "화이트", "다크", "더블 샷", "클래식" };
		String[] menuNmTwo = { "초코", "바닐라", "자바 칩", "돌체", "딸기", "카라멜", "슈크림", "돌체", "카페", "헤이즐넛", "크림", "흑설탕" };
		String[] menuNmThr = { "아메리카노", "에스프레소", "프라푸치노", "티", "라떼", "콜드 브루", "마키아또", "카푸치노", "아포가토", "블렌디드", "에이드",
				"주스", "모카" };
		
		String menuNmOne_save = menuNmOne[rand.nextInt(menuNmOne.length)];
		String menuNmTwo_save = menuNmTwo[rand.nextInt(menuNmTwo.length)];
		String menuNmThr_save = menuNmThr[rand.nextInt(menuNmThr.length)];
		String menuNm = menuNmOne_save + " " + menuNmTwo_save + " " + menuNmThr_save;
		String menuDesc = menuNmTwo_save + "(이)가 들어간 " + menuNmOne_save + " " + menuNmThr_save + " 입니다.";
		if (str.equals("nm")) {
			return menuNm;
		}
		else if (str.equals("desc")) {
			return menuDesc;
		}
		else {
			return "nm 혹은 desc 중에 하나를 치시오";
		}
	}
	public static String makeRanNm() {
		String[] lasNm = {"권", "최", "박", "홍", "김", "이", "피", "장", "송", "정", "한", "고", "배", "구", "오", "우", "서", "진", "강", "곽", "위", "임", "류", "맹", "팽", "문", "민", "백", "양", "성", "제갈", "신", "안", "원", "유","윤", "전", "조", "함", "황", "남궁", "노", "허"};
		String[] firNm = {"민수", "철수", "제인", "근혜", "명박", "대중", "정희", "두한", "종원", "경영", "유라", "순실", "해인", "준영", "은우", "수현", "근석", "녜힁", "태희", "지은", "지용", "재석", "명수", "준하", "지효", "세경", "봄", "지혜", "빈", "가인", "진구", "이슬", "영민", "새로이", "바다"};
		String cusNm = lasNm[rand.nextInt(lasNm.length)] + firNm[rand.nextInt(firNm.length)];
		return cusNm;
	}
	
	public static String makeRanPhone() {
		String str = "010-";
		for (int i = 0; i < 8; i++) {
			if (i == 4) {
				str += "-";
			}
			str += rand.nextInt(10);
		}
		return str;
	}
	public static String makeRanDateFu(int i) { // 미래 시간 만들기 i에 일 수를 넣어 범위 조정
		String date = "";
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, rand.nextInt(i)); // 이거가 핵심, 과거로 하고 싶다면 -1 곱하기
		String year = now.get(Calendar.YEAR) + "";
		String month = (now.get(Calendar.MONTH) + 1) > 9 ? (now.get(Calendar.MONTH) + 1) + ""
				: "0" + (now.get(Calendar.MONTH) + 1);
		String day = now.get(Calendar.DATE) > 9 ? now.get(Calendar.DATE) + "" : "0" + now.get(Calendar.DATE);

		date = year + "-" + month + "-" + day;
		// java.sql.Date.valueOf() 는 날짜 형식이 YYYY-MM-DD 형식으로 들어와야 java.lang 어쩌구 오류 안생김

		return date;
	}
	
	public static String makeRanDatePa(int i) { // 과거 시간 만들기 i에 일 수를 넣어 범위 조정
		String date = "";
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, rand.nextInt(i)*-1); // 이거가 핵심, 과거로 하고 싶다면 -1 곱하기
		String year = now.get(Calendar.YEAR) + "";
		String month = (now.get(Calendar.MONTH) + 1) > 9 ? (now.get(Calendar.MONTH) + 1) + ""
				: "0" + (now.get(Calendar.MONTH) + 1);
		String day = now.get(Calendar.DATE) > 9 ? now.get(Calendar.DATE) + "" : "0" + now.get(Calendar.DATE);

		date = year + "-" + month + "-" + day;
		// java.sql.Date.valueOf() 는 날짜 형식이 YYYY-MM-DD 형식으로 들어와야 java.lang 어쩌구 오류 안생김

		return date;
	}
	
	public static String makeRanCarNum() {
		String[] carNoTwo = { "가", "나", "다", "라", "마", "바", "공", "해", "육", "합", "국", "허", "하", "호", "배" };
		int carOne;
		int carThr;
		String carNoOne = "";
		String carNoThr = "";
		String carNo = "";
		carOne = (rand.nextInt(99) + 1);
		carThr = (rand.nextInt(9999) + 1);
		carNoOne = String.format("%02d", carOne);
		carNoThr = String.format("%04d", carThr);
		carNo = carNoOne + carNoTwo[rand.nextInt(carNoTwo.length)] + " " + carNoThr;
		return carNo;
	}
}
