# RanName

**RanName** is a random user name generator. It can generate any number of random users at one time.

## How To

There are many important parameters needed to be considered when use this generator **:**
  - (int) nameLen
  - (int) pwdLen
  - (int) userNum
  - (String) userTokens
  - (String) outPutFile

`nameLen` is the length of user name. `pwdLen` is the length of password. `userNum` is the number of users to be generated. `userTokens` is the specific string that is required to be part of the user name. `outPutFile` is the file that store all generated users.

`userTokens` can receive string with space. But in processing, the space within string will be trimed, and there will always have an underscore `_` be attached to the end of the string. For example, if the value of `userTokens` is `a b c`, then the tokens in user name will be `abc_`.

You can access generated users directly without saving to file. The class `RanNameGenerator` uses `ArrayList<ArrayList<String>>` to store all generated users, and function `getStoredUsers()` will return the result. 

### Constructor

`RanName(int nameLen, int pwdLen, int userNum, String userTokens, String outPutFile)`

`RanNameFile(String outPutFile, String contentFormat, ArrayList<ArrayList<String>> users)`

### File format

This generator supports three output formats: **raw**, **csv**, **json**.

## Example
### Create users without saving to file
  ```
  RanName a = new RanName(20, 20, 5, "user", "");
  RanNameGenerator b = new RanNameGenerator(a);
  b.createUsers(); // Create users
  System.out.println(b.getStoredUsers()); // print users
  ```
### Create users and save to file in specific format
**raw** format
  ```
  RanName a = new RanName(20, 20, 5, "user", "H:\\Data\\output.txt");
  RanNameGenerator b = new RanNameGenerator(a);
  b.createUsers(); // Create users
  RanNameFile ranFile = new RanNameFile(b.getOutPutFile(), "raw", b.getStoredUsers());
  ranFile.store();
  ```
**Output**
  ```
  [user_HVYVa"dn&2!63D9, zg#Pbi#l#$0$%2G6YpTe]
  [user_86Zj$UDOadMz$n$, A8Q6Ia2Wh$jh$5fqUp$"]
  [user_&5!8AX1Yi#Mw"2!, %57"9Kr75PINn"My$#m#]
  [user_B&2CmNNw!h%!8&", 6F"&2I6pv$%f%2#4B4Q6]
  [user_"ngh&&d"3$4s#97, !9#3S9DcoQm$"%j#85!#]
  ```
  
**csv** format
  ```
  RanName a = new RanName(20, 20, 5, "user", "H:\\Data\\output.txt");
  RanNameGenerator b = new RanNameGenerator(a);
  b.createUsers(); // Create users
  RanNameFile ranFile = new RanNameFile(b.getOutPutFile(), "csv", b.getStoredUsers());
  ranFile.store();
  ```
**Output**
  ```
  UserName,Password
  user_fzl"745K2YWiZox,%940I!344Kg"Jt!5o3I8
  user_&Wf"5d"4Vl1M51U,Pyr!!$9&78H3BH#Lf5Xl
  user_#o$&5#8OF1Bao!&,9zi!4#86AKjhe$g$"7!4
  user_O3GqjBl#%TB&Jp",%$5Z5CMRa2U#$51S6CLw
  user_Ucw&3%%&&2%9KsK,Rf$js%$#65G47TOk3JCJ
  ```
  
**json** format and don't provide `userTokens`
  ```
  RanName a = new RanName(20, 20, 5, "", "H:\\Data\\output.txt");
  RanNameGenerator b = new RanNameGenerator(a);
  b.createUsers(); // Create users
  RanNameFile ranFile = new RanNameFile(b.getOutPutFile(), "json", b.getStoredUsers());
  ranFile.store();
  ```
**Output**
  ```
  {
    "users": {
		  {
			  "name": "I31C%Hg0Fc%Ea$0A65Yu",
			  "password": "uk#"4c0I!%5NBkwRgq&e"
		  },
		  {
			  "name": "3LxzIu9#%#3v#41IV7Pc",
			  "password": "oy%$2MEaj"n!%8fq%4%&"
		  },
		  {
			  "name": "JCuFrx"x&%2$91E2###3",
			  "password": "6"7EW4CnfPy"0z&3E#4C"
		  },
		  {
			  "name": "J$8Qx&a3gVf%9e!2!%56",
			  "password": "6Fp%6CoeJu##v"9A62Yi"
		  },
		  {
			  "name": "e#uu!03m$18RCNy09UcV",
			  "password": "Cm"zju#2!"9RUfc!n%5U"
		  },
	  }
  }
  ```
