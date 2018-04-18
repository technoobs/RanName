/*
 * Class to generate random user name according
 * to provided option values
 * 
 */

package io.technoobs.boost.RanName;

import java.util.Random;
import java.util.ArrayList;

public class RanNameGenerator extends RanName {

	private ArrayList<ArrayList<String>> storedUsers = new ArrayList<ArrayList<String>>();

	public RanNameGenerator(RanName a) {
		nameLen = a.getNameLen();
		pwdLen = a.getPwdLen();
		userNum = a.getUserNum();
		userTokens = a.getUserTokens();
		outPutFile = a.getOutPutFile();

		if (!userTokens.isEmpty()) {
			userTokens = processNameTokens(userTokens);
		}
	}
	
	/**
	 * @return the storedUsers
	 */
	public ArrayList<ArrayList<String>> getStoredUsers() {
		return storedUsers;
	}

	/*
	 * Create single user
	 */
	public String createUser() {
		// User name
		StringBuilder userNameBuilder = new StringBuilder(nameLen);
		if (userTokens.isEmpty()) {
			for (int i = 0; i < nameLen; i++) {
				getRandomChar(userNameBuilder);
			}
			return userNameBuilder.toString();
		} else {
			for (int i = 0; i < nameLen - userTokens.length(); i++) {
				getRandomChar(userNameBuilder);
			}
			return userTokens + userNameBuilder.toString();
		}
	}

	/*
	 * Create multiple users
	 */
	public void createUsers() {
		for (int i = 0; i < userNum; i++) {
			ArrayList<String> storeMapRow = new ArrayList<String>();
			String rowUserName = createUser();
			String rowUserPwd = createPwd();

			storeMapRow.add(rowUserName);
			storeMapRow.add(rowUserPwd);

			storedUsers.add(i, storeMapRow);
		}
	}

	/*
	 * Create password
	 */
	public String createPwd() {
		// User password
		StringBuilder userPwdBuilder = new StringBuilder(pwdLen);
		for (int i = 0; i < pwdLen; i++) {
			getRandomChar(userPwdBuilder);
		}
		return userPwdBuilder.toString();
	}

	/*
	 * Process input name tokens (remove space, and always put '_' after name
	 * tokens)
	 */
	private String processNameTokens(String nameTokens) {
		String newNameTokens = "";
		String noSpaceTokens = nameTokens.replaceAll("\\s+", "");
		if (noSpaceTokens.charAt(noSpaceTokens.length() - 1) != '_') {
			newNameTokens = noSpaceTokens + "_";
		}
		return newNameTokens;
	}

	/*
	 * Generate random character for user name and user password
	 */
	private StringBuilder getRandomChar(StringBuilder s) {
		/*
		 * ASCII code range 33 ~ 38 (1) 48 ~ 57 (2) 65 ~ 90 (3) 97 ~ 122 (4)
		 */
		int codeNum = 0;
		int charType = getRandomNum(1, 4);
		// Get random character
		if (charType == 1) {
			codeNum = getRandomNum(33, 38);
		} else if (charType == 2) {
			codeNum = getRandomNum(48, 57);
		} else if (charType == 3) {
			codeNum = getRandomNum(65, 90);
		} else if (charType == 4) {
			codeNum = getRandomNum(97, 122);
		}
		s.append(Character.toString((char) codeNum));
		return s;
	}

	/*
	 * Get random number in specified range
	 */
	private int getRandomNum(int min, int max) {
		Random ranType = new Random();
		ranType.setSeed(System.nanoTime()); // set random seed
		return ranType.nextInt(max - min + 1) + min;
	}
	
}
