package grade;

public class Grade {
	private int grdNo;
	private String grdNm;
	private String grdBene;
	private String delYn;

	public Grade(int grdNo, String grdNm, String grdBene, String delYn) {
		this.grdNo = grdNo;
		this.grdNm = grdNm;
		this.grdBene = grdBene;
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "Grade [grdNo=" + grdNo + ", grdNm=" + grdNm + ", grdBene=" + grdBene + ", delYn=" + delYn + "]\n";
	}

}
