package user;

public class UserMa {

	private int userNo;
	private String userNm;
	private String userId;
	private String userPass;
	private String userIdtf;

	public UserMa(int userNo, String userNm, String userId, String userPass, String userIdtf) {
		super();
		this.userNo = userNo;
		this.userNm = userNm;
		this.userId = userId;
		this.userPass = userPass;
		this.userIdtf = userIdtf;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserIdtf() {
		return userIdtf;
	}

	public void setUserIdtf(String userIdtf) {
		this.userIdtf = userIdtf;
	}

	@Override
	public String toString() {
		return "UserMa [userNo=" + userNo + ", userNm=" + userNm + ", userId=" + userId + ", userPass=" + userPass
				+ ", userIdtf=" + userIdtf + "]";
	}

}
