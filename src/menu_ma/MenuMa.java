package menu_ma;

public class MenuMa {
	private int menuMa;
	private String menuNm;
	private String menuIntro;
	private int menuPri;
	private String delYn;

	public MenuMa(int menuMa, String menuNm, String menuIntro, int menuPri, String delYn) {
		this.menuMa = menuMa;
		this.menuNm = menuNm;
		this.menuIntro = menuIntro;
		this.menuPri = menuPri;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "MenuMa [menuMa=" + menuMa + ", menuNm=" + menuNm + ", menuIntro=" + menuIntro + ", menuPri=" + menuPri
				+ ", delYn=" + delYn + "]\n";
	}

}
