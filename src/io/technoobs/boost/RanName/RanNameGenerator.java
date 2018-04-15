/*
 * Class to generate random user name according
 * to provided option values
 * 
 */

package io.technoobs.boost.RanName;

import java.util.Random;
import java.util.ArrayList;

public class RanNameGenerator extends RanName {

	ArrayList<ArrayList<String>> storeMap = new ArrayList<ArrayList<String>>();

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
	public ArrayList<ArrayList<String>> createMultipleUsers() {
		for (int i = 0; i < userNum; i++) {
			ArrayList<String> storeMapRow = new ArrayList<String>();
			String rowUserName = createUser();
			String rowUserPwd = createPwd();

			System.out.println("Created username is: " + rowUserName);
			System.out.println("Created user password is: " + rowUserPwd);

			storeMapRow.add(rowUserName);
			storeMapRow.add(rowUserPwd);

			System.out.println("First element of row is: " + storeMapRow.get(0));
			System.out.println("Second element of row is: " + storeMapRow.get(1));

			for (String listEle : storeMapRow) {
				System.out.println("storeMapRow element is: " + listEle);
			}

			System.out.println("--------------------------------------------------");

			storeMap.add(i, storeMapRow);
		}

		for (ArrayList<String> temp : storeMap) {
			System.out.println(temp);
		}

		return storeMap;
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
	 * Store generated username and password into file
	 */
	public void storeInFile(String file) {
		RanNameFile fileProcessor = new RanNameFile();
//		fileProcessor.printName(content, file);
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

	public void TestArrayList() {
		storeMap.add(new ArrayList<String>());
		storeMap.get(0).add(new String("sssssss"));
	}

	/*
	 * Store generated users
	 */
	private void storeGeneratedUsers(int row, int col, Object content) {
		storeMap.get(row).add(col, content.toString());

		for (int i = 0; i < row; i++) {
			storeMap.add(new ArrayList<String>());
			for (int j = 0; j < col; j++) {
				storeMap.get(i).add(j, "j");
			}

		}
	}

}
