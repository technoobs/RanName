package io.technoobs.boost.RanName;

public class RanName {

	// Length of username
	protected int nameLen;
	// Length of password
	protected int pwdLen;
	// Total number of users to be created
	protected int userNum;
	// String tokens used for username
	protected String userTokens;
	// File to store all generated users
	protected String outPutFile;

	/*
	 * Default constructor
	 */
	public RanName() {
		
	}
	
	public RanName(int nameLen, int pwdLen, int userNum, 
			String userTokens, String outPutFile) {
		this.nameLen = nameLen;
		this.pwdLen = pwdLen;
		this.userNum = userNum;
		this.userTokens = userTokens;
		this.outPutFile = outPutFile;
	}
	
	

	public int getNameLen() {
		return nameLen;
	}



	public void setNameLen(int nameLen) {
		this.nameLen = nameLen;
	}



	public int getPwdLen() {
		return pwdLen;
	}



	public void setPwdLen(int pwdLen) {
		this.pwdLen = pwdLen;
	}



	public int getUserNum() {
		return userNum;
	}



	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}



	public String getUserTokens() {
		return userTokens;
	}



	public void setUserTokens(String userTokens) {
		this.userTokens = userTokens;
	}



	public String getOutPutFile() {
		return outPutFile;
	}



	public void setOutPutFile(String outPutFile) {
		this.outPutFile = outPutFile;
	}

}
