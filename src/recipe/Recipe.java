package recipe;

public class Recipe {
	private int recNo;
	private int menuNo;
	private int furnNo;
	private String recIng;
	private String delYn;

	public Recipe(int recNo, int menuNo, int furnNo, String recIng, String delYn) {
		this.recNo = recNo;
		this.menuNo = menuNo;
		this.furnNo = furnNo;
		this.recIng = recIng;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "Recipe [recNo=" + recNo + ", menuNo=" + menuNo + ", furnNo=" + furnNo + ", recIng=" + recIng
				+ ", delYn=" + delYn + "]\n";
	}

}
