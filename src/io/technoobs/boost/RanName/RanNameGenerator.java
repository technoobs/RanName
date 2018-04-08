/*
 * Class to generate random user name according
 * to provided option values
 * 
 */

package io.technoobs.boost.RanName;

import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RanNameGenerator {

	private String nameTokens;
	// name length
	private int nameLen;
	// password length
	private int pwdLen;
	// Map to store username and password
	HashMap<String, String> nameMap = new HashMap<String, String>();

	/*
	 * Default constructor
	 */
	public RanNameGenerator(int nameLen, int pwdLen) {
		this.nameLen = nameLen;
		this.pwdLen = pwdLen;
	}

	/*
	 * Constructor with name token
	 */
	public RanNameGenerator(String nameTokens, int nameLen, int pwdLen) {

		this.nameTokens = processNameTokens(nameTokens);
		this.nameLen = nameLen;
		this.pwdLen = pwdLen;
	}

	/*
	 * Create multiple default users or token users at one time. <num> is the
	 * parameter to define the total number of users to be generated.
	 * 
	 * A HashMap in which "USERNAME" and "PASSWORD" are stored will be returned.
	 */
	public HashMap<String, String> createMultiUsers(int num) {
		if (num <= 0) {
			// throw error
		} else {
			for (int i = 0; i < num; i++) {
				nameMap.put(createUser(), createPwd());
			}
		}

		return nameMap;
	}

	public HashMap<String, String> createMultiTokenUsers(int num) {
		if (num <= 0) {
			// throw error
		} else {
			for (int i = 0; i < num; i++) {
				nameMap.put(createTokenUser(), createPwd());
			}
		}

		return nameMap;
	}

	/*
	 * Create user without name token
	 */
	public String createUser() {
		System.out.println("Starting to create users...");
		// User name
		StringBuilder userNameBuilder = new StringBuilder(nameLen);
		for (int i = 0; i < nameLen; i++) {
			getRandomChar(userNameBuilder);
		}
		return userNameBuilder.toString();
	}

	/*
	 * Create user with name token
	 */
	public String createTokenUser() {
		System.out.println("Starting to create users with tokens...");
		// User name
		StringBuilder userNameBuilder = new StringBuilder(nameLen);
		for (int i = 0; i < nameLen - nameTokens.length(); i++) {
			getRandomChar(userNameBuilder);
		}
		return nameTokens + userNameBuilder.toString();
	}

	/*
	 * Create password
	 */
	public String createPwd() {
		System.out.println("Starting to create user password...");
		// User password
		StringBuilder userPwdBuilder = new StringBuilder(pwdLen);
		for (int i = 0; i < pwdLen; i++) {
			getRandomChar(userPwdBuilder);
		}
		return userPwdBuilder.toString();
	}

	/*
	 * Store generated username and password in file
	 */
	// public String printName(String outputFile) {
	//
	// }

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
			System.out.println("Character random code is: " + codeNum);
		} else if (charType == 2) {
			codeNum = getRandomNum(48, 57);
			System.out.println("Character random code is: " + codeNum);
		} else if (charType == 3) {
			codeNum = getRandomNum(65, 90);
			System.out.println("Character random code is: " + codeNum);
		} else if (charType == 4) {
			codeNum = getRandomNum(97, 122);
			System.out.println("Character random code is: " + codeNum);
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

	public static void main(String[] args) {
		RanNameGenerator x = new RanNameGenerator("user01", 12, 12);
		// System.out.println(x.createTokenUser());
		// System.out.println(x.createPwd());

		// RanNameGenerator x = new RanNameGenerator(12, 12);
		HashMap<String, String> nameMap = x.createMultiTokenUsers(10);
		Set set = nameMap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}
	}

}

